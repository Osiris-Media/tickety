package com.osiris.tickety.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created By francislagueu on 6/1/24
 */
@ResponseStatus(code = UNAUTHORIZED)
public class NotAuthorizedException extends RootException{
    @Serial
    private static final long serialVersionUID = -711441617476620028L;

    public NotAuthorizedException() {
        super(UNAUTHORIZED);
    }
}
