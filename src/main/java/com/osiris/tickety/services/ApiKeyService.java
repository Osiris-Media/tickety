package com.osiris.tickety.services;

import com.osiris.tickety.entities.ApiKeyEntity;
import com.osiris.tickety.exceptions.ResourceNotFoundException;
import com.osiris.tickety.repositories.ApiKeyRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.osiris.tickety.utils.CryptoUtils.randomKey;
import static java.lang.String.format;

/**
 * Created By francislagueu on 6/2/24
 */
@Slf4j
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ApiKeyService extends BaseService<ApiKeyEntity> {
    @Getter
    private final ApiKeyRepository repository;

    @Override
    protected void activitiesBeforeCreateEntity(final ApiKeyEntity entity) {
        entity.setIsActive(true);
        entity.setKey(randomKey(18));
    }

    public Optional<ApiKeyEntity> findByKeyOptional(final String key) {
        log.debug("[retrieving] apiKey");
        return this.repository.findByKeyAndIsActive(key, true);
    }

    public ApiKeyEntity findFirstByCompanyIdAndIsActive(final Long companyId) {
        log.debug("[retrieving] apiKey with companyId {}", companyId);
        return this.repository.findFirstByCompanyIdAndIsActive(companyId, true);
    }

    @Transactional
    public void inactivate(final Long id) {
        log.info("[inactivating] apiKey with id '{}'", id);

        final Optional<ApiKeyEntity> apiKeyOptional = this.getRepository().findById(id);
        if (apiKeyOptional.isEmpty()) {
            throw new ResourceNotFoundException(format("apiKey '%s' not found", id));
        }

        final ApiKeyEntity entity = apiKeyOptional.get();
        entity.setIsActive(false);
        this.update(entity);
    }
}
