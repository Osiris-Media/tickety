package com.osiris.tickety.models.responses.management;

import java.time.LocalDateTime;

/**
 * Created By francislagueu on 6/2/24
 */
public record ApiKeyResponse(Long id,
                             Long companyId,
                             String name,
                             String key,
                             Boolean isActive,
                             String createdBy,
                             String updatedBy,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {
}
