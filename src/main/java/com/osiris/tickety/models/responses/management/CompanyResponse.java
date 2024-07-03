package com.osiris.tickety.models.responses.management;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created By francislagueu on 6/2/24
 */
public record CompanyResponse(Long id,
                              String slug,
                              String name,
                              String officialName,
                              String federalTaxId,
                              String stateTaxId,
                              String phone,
                              String email,
                              String addressStreet,
                              String addressStreetNumber,
                              String addressComplement,
                              String addressCityDistrict,
                              String addressPostCode,
                              String addressCity,
                              String addressStateCode,
                              String addressCountry,
                              BigDecimal addressLatitude,
                              BigDecimal addressLongitude,
                              Boolean isManagement,
                              Boolean isInternal,
                              Boolean isPlatform,
                              String createdBy,
                              String updatedBy,
                              LocalDateTime createdAt,
                              LocalDateTime updatedAt) {
}
