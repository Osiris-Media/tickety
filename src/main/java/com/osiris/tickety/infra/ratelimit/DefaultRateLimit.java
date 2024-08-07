package com.osiris.tickety.infra.ratelimit;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * Created By francislagueu on 6/2/24
 */
@Component
@RequiredArgsConstructor
public class DefaultRateLimit extends BaseRateLimit{
    @Value("${rate-limit.default.name}")
    private String name;

    @Value("${rate-limit.default.max-requests}")
    private int maxRequests;

    @Value("${rate-limit.default.refill-in-seconds}")
    private int refillInSeconds;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Bandwidth getLimit() {
        return Bandwidth.classic(
                this.maxRequests,
                Refill.intervally(this.maxRequests, Duration.ofSeconds(this.refillInSeconds)));
    }
}
