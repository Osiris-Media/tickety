package com.osiris.tickety.exceptions;

import com.osiris.tickety.shared.ApiErrorDetails;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By francislagueu on 6/1/24
 */
@Getter
public class RootException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 6378336966214073013L;

    private final HttpStatus httpStatus;
    private final List<ApiErrorDetails> errors = new ArrayList<>();

    public RootException(@NonNull final HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }

    public RootException(@NonNull final HttpStatus httpStatus, final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
