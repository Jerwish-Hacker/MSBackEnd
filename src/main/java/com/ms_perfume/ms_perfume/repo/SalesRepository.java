package com.ms_perfume.ms_perfume.repo;


import com.ms_perfume.ms_perfume.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository  extends JpaRepository<Sales,Long> {
}
