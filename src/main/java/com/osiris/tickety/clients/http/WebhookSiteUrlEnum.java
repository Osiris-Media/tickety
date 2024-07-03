package com.osiris.tickety.clients.http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created By francislagueu on 7/3/24
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum WebhookSiteUrlEnum {
    POST("/");
    private final String url;
}
