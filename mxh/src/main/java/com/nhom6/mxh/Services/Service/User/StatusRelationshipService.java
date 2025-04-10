package com.nhom6.mxh.Services.Service.User;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.User.StatusRelationship;

@Service
public interface StatusRelationshipService {
    StatusRelationship findById(Long id);
}
