package com.foodparcel.Service;

/**Yusrah Soeker
 * 218150768
 */

import com.foodparcel.entity.Donation;
import java.util.Set;

public interface DonationService extends IService <Donation, String> {
    Set<Donation> getAll();
}

