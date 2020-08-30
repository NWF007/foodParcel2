package com.foodparcel.Repository;

import com.foodparcel.entity.Donation;
import java.util.Set;

public interface DonationRepository extends IRepository <Donation, String> {
    Set<Donation> getAll();
}
