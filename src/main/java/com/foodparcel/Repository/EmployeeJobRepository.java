package com.foodparcel.Repository;

import com.foodparcel.entity.EmployeeJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJobRepository extends JpaRepository<EmployeeJob, String> {
}
