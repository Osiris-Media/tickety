package com.osiris.tickety.exceptions;

import com.osiris.tickety.constants.AppConstants;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Created By francislagueu on 6/1/24
 */
@ResponseStatus(code = INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RootException{
    @Serial
    private static final long serialVersionUID = 694110374288090930L;

    public InternalServerErrorException() {
        super(INTERNAL_SERVER_ERROR, AppConstants.API_DEFAULT_ERROR_MESSAGE);
    }
}
