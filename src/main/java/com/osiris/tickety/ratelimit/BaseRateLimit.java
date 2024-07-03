package com.osiris.tickety.ratelimit;

import io.github.bucket4j.Bandwidth;

/**
 * Created By francislagueu on 6/2/24
 */
public abstract class BaseRateLimit {
    public abstract String getName();

    public abstract Bandwidth getLimit();
}
