package demo.service;

import java.util.List;

import demo.entity.BloodDonor;

public interface BloodDonorServices {

    List<BloodDonor> getAllBloodDonors();

    BloodDonor getBloodDonorById(Long id);

    BloodDonor createNewBloodDonor(BloodDonor bloodDonor);

    BloodDonor updateBloodDonor(Long id, BloodDonor BloodDonor);

    void deleteBloodDonor(Long id);
}
