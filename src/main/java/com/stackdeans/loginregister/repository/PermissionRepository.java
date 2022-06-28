package com.stackdeans.loginregister.repository;

import com.stackdeans.loginregister.models.EPermission;
import com.stackdeans.loginregister.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(EPermission name);
}
