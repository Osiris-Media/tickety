package com.osiris.tickety.utils;

import com.osiris.tickety.entities.BaseEntity;
import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created By francislagueu on 6/2/24
 */
@UtilityClass
public class UrlUtils {
    public static String encodeURLComponent(final String component) {
        return URLEncoder.encode(component, StandardCharsets.UTF_8);
    }

    public static URI buildUriFromEntity(final BaseEntity entity) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

    public static URI buildUriFromEntityWithPath(final BaseEntity entity, final String path) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path)
                .buildAndExpand(entity.getId())
                .toUri();
    }
}
