package com.osiris.tickety.models.requests.management;

import java.math.BigDecimal;

/**
 * Created By francislagueu on 6/2/24
 */
public record UpdateCompanyRequest(String slug,
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
                                   Boolean isPlatform) {
}
