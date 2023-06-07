package com.spring.redis.service;

import com.spring.redis.entity.Organization;
import com.spring.redis.intfc.Cacheable;
import com.spring.redis.repo.OrganizationRepository;
import com.spring.redis.repo.RedisCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository orgRepository;
    private final RedisCacheRepository cacheRepository;

    public Organization saveOrg(Organization organization) {
        orgRepository.save(organization);
        if (organization instanceof Cacheable) {
            cacheRepository.saveOrUpdate("org", organization.getOrgId(), organization);
        }
        return organization;
    }

    public Organization getOrgById(long id) {
        var organization = (Organization) cacheRepository.getById("org", id);
        if (organization == null) {
            organization = orgRepository.findById(id).get();
            cacheRepository.saveOrUpdate("org", organization.getOrgId(), organization);
        }
        return organization;
    }

    public List<Organization> getAll() {
        var organizations = cacheRepository.getAll("org");
        if (organizations.isEmpty()) {
            return orgRepository.findAll();
        }
        return organizations.values().stream().map(org -> (Organization) org).toList();
    }
}
