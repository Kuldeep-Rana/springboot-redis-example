package com.spring.redis.controller;

import com.spring.redis.entity.Organization;
import com.spring.redis.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org/v1")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService orgService;

    @PostMapping
    public String createOrg(@RequestBody Organization org) {
        orgService.saveOrg(org);
        return "Organization created successfully with id %d".formatted(org.getOrgId());
    }

    @GetMapping("/{id}")
    public Organization getOrgById(@PathVariable long id) {
        return orgService.getOrgById(id);
    }

    @GetMapping()
    public List<Organization> getOrgById() {
        return orgService.getAll();
    }
}