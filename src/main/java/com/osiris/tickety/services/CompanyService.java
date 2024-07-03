package com.osiris.tickety.services;

import com.osiris.tickety.entities.CompanyEntity;
import com.osiris.tickety.exceptions.ResourceNotFoundException;
import com.osiris.tickety.repositories.CompanyRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created By francislagueu on 6/2/24
 */
@Slf4j
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class CompanyService extends BaseService<CompanyEntity>{
    @Getter
    private final CompanyRepository repository;

    public Optional<CompanyEntity> findBySlugOptional(final String slug) {
        log.debug("[retrieving] company with slug '{}'", slug);
        if (StringUtils.isBlank(slug)) {
            return Optional.empty();
        }
        return this.repository.findBySlug(slug);
    }

    public CompanyEntity findBySlug(final String slug) {
        return this.findBySlugOptional(slug)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        String.format("company with slug '%s' not found", slug)));
    }
}
