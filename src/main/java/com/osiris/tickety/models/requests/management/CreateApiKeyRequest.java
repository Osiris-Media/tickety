package com.osiris.tickety.models.requests.management;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Created By francislagueu on 6/2/24
 */
public record CreateApiKeyRequest(@NotNull Long companyId, @NotBlank String name) {
}
