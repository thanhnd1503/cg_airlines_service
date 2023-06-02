package com.airline.repository;

import com.airline.entity.Role;
import com.airline.entity.User;
import com.airline.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    void removeUserRoleById(long id);
    @Query(value = "select  ur from UserRole ur where ur.user = :user and ur.role = :role")
    UserRole getUserRoleByUserId (User user, Role role);

}