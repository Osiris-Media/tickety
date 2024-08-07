package com.osiris.tickety.clients.slack;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.scheduling.annotation.Async;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created By francislagueu on 7/3/24
 */
@Slf4j
public abstract class BaseSlackClient {

    public abstract String getEnv();

    public abstract String getUrl();

    public abstract String getChannel();

    @Async
    public void notify(final String message) {
        try {

            final WebhookResponse response =
                    Slack.getInstance().send(this.getUrl(), this.buildBodyMessage(message));

            if (response.getCode() != 200) {
                log.warn("[SLACK][ERROR] status[{}] body[{}]", response.getCode(), response.getBody());

            } else {
                log.info("[SLACK] error message send with success");
            }

        } catch (final Exception ex) {
            log.error("[SLACK][ERROR] An error has occurred when sending error message", ex);
        }
    }

    private String buildBodyMessage(final String message) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        final String timestamp =
                formatter.format(OffsetDateTime.now().atZoneSameInstant(ZoneId.of("America/Sao_Paulo")));

        return format(
                """
                {
                  "channel": "#%s",
                  "text": "*error*",
                  "blocks": [
                    {
                      "type": "section",
                      "fields": [
                        {
                          "type": "mrkdwn",
                          "text": "*Team:*\\n API"
                        },
                        {
                          "type": "mrkdwn",
                          "text": "*When:*\\n%s"
                        },
                        {
                          "type": "mrkdwn",
                          "text": "* Env:*\\n%s"
                        },
                        {
                          "type": "mrkdwn",
                          "text": "*Reason:*\\n%s."
                        }
                      ]
                    },
                    %s
                  ]
                }
                """,
                this.getChannel(),
                timestamp,
                this.getEnv(),
                StringEscapeUtils.escapeJson(message),
                this.buildTraceAndLogButtons());
    }

    private String buildTraceAndLogButtons() {
        // Link to your logs system filtered by traceId
        final String logUrl = "http://example.com";
        // Link to your trace system filtered by traceId
        final String traceUrl = "http://example.com";

        return isNotBlank(logUrl)
                ? format(
                """
            {
                  "type": "actions",
                  "elements": [
                    {
                      "type": "button",
                      "url": "%s",
                      "style": "primary",
                      "text": {
                        "type": "plain_text",
                        "text": "Logs",
                        "emoji": true
                      },
                      "value": "btn-logs",
                      "action_id": "logUrl"
                    },
                    {
                      "type": "button",
                      "url": "%s",
                      "text": {
                        "type": "plain_text",
                        "text": "Traces",
                        "emoji": true
                      },
                      "value": "btn-trace",
                      "action_id": "traceUrl"
                    }
                  ]
                }
            """,
                logUrl, traceUrl)
                : StringUtils.EMPTY;
    }
}
