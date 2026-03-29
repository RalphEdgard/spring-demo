package org.example.repository;

import org.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealUserRepository extends JpaRepository<UserEntity, Long> {}
