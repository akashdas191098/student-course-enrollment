package com.scb.enrollment.Repositories;

import com.scb.enrollment.Entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<Enrollment, Integer> {
}
