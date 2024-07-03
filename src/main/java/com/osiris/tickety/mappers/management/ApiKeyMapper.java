package com.osiris.tickety.mappers.management;

import com.osiris.tickety.entities.ApiKeyEntity;
import com.osiris.tickety.models.requests.management.CreateApiKeyRequest;
import com.osiris.tickety.models.requests.management.UpdateApiKeyRequest;
import com.osiris.tickety.models.responses.management.ApiKeyResponse;
import org.mapstruct.Mapper;

/**
 * Created By francislagueu on 6/2/24
 */
@Mapper(componentModel = "spring")
public interface ApiKeyMapper extends ManagementBaseMapper<ApiKeyEntity, CreateApiKeyRequest, UpdateApiKeyRequest, ApiKeyResponse>{
    @Override
    ApiKeyEntity toEntity(CreateApiKeyRequest request);

    @Override
    ApiKeyResponse toManagementResponse(ApiKeyEntity entity);
}
