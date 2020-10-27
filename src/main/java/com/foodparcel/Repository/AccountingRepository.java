package com.foodparcel.Repository;

import com.foodparcel.entity.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingRepository.java
 * Submission 7
 * Date: 30 August 2020
 * Edited: 25 October 2020
 */
@Repository
public interface AccountingRepository extends JpaRepository<Accounting, String> {
    //Set<Accounting> getAll();
}
