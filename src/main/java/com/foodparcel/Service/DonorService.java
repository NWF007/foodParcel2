package com.foodparcel.Service;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.entity.Donor;
import java.util.Set;

public interface DonorService extends IService <Donor, String> {
    Set<Donor> getAll();
}