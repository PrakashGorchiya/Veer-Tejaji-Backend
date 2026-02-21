package demo.service;

import java.util.List;

import demo.entity.Donor;

public interface DonorServices {

    List<Donor> getAllDonors();

    Donor getDonorById(Long id);

    Donor createNewDonor(Donor donor);

    Donor updateDonor(Long id, Donor donor);

    void deleteDonor(Long id);
}
