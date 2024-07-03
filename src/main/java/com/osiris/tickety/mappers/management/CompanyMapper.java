package com.osiris.tickety.mappers.management;

import com.osiris.tickety.entities.CompanyEntity;
import com.osiris.tickety.models.requests.management.CreateCompanyRequest;
import com.osiris.tickety.models.requests.management.UpdateCompanyRequest;
import com.osiris.tickety.models.responses.management.CompanyResponse;
import org.mapstruct.Mapper;

/**
 * Created By francislagueu on 6/2/24
 */
@Mapper(componentModel = "spring")
public interface CompanyMapper extends ManagementBaseMapper<CompanyEntity, CreateCompanyRequest, UpdateCompanyRequest, CompanyResponse> {
}
