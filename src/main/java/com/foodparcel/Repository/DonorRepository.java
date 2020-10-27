package com.foodparcel.Repository;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DonorRepository extends JpaRepository <Donor, String> {
}