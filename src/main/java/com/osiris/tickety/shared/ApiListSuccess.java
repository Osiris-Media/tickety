package com.osiris.tickety.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created By francislagueu on 6/2/24
 */
public record ApiListSuccess<T>(List<T> data) {
    public static <T, S extends Collection<T>> ApiListSuccess<T> of(final S data) {
        return new ApiListSuccess<>(new ArrayList<>(data));
    }

    public static <T> ApiListSuccess<T> of(final List<T> data) {
        return new ApiListSuccess<>(data);
    }
}
