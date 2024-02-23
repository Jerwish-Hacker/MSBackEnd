package com.ms_perfume.ms_perfume.repo;


import com.ms_perfume.ms_perfume.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
