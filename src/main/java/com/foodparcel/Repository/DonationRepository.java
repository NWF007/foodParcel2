package com.foodparcel.Repository;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository <Donation, String> {
}
