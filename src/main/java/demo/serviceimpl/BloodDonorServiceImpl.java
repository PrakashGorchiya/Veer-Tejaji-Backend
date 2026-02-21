package demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.BloodDonor;
import demo.repository.BloodDonorRepository;
import demo.service.BloodDonorServices;

@Service
public class BloodDonorServiceImpl implements BloodDonorServices {

    @Autowired
    private BloodDonorRepository bloodDonorRepository;

    // GET ALL
    @Override
    public List<BloodDonor> getAllBloodDonors() {
        return bloodDonorRepository.findAll();
    }

    // GET BY ID
    @Override
    public BloodDonor getBloodDonorById(Long id) {
        return bloodDonorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blood Donor Member not found with id: " + id));
    }

    // CREATE
    @Override
    public BloodDonor createNewBloodDonor(BloodDonor member) {
        return bloodDonorRepository.save(member);
    }

    // UPDATE
    @Override
    public BloodDonor updateBloodDonor(Long id, BloodDonor member) {

        BloodDonor existing = bloodDonorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blood Donor Member not found with id: " + id));

        existing.setName(member.getName());
        existing.setMobile(member.getMobile());
        existing.setCity(member.getCity());
        existing.setBloodGroup(member.getBloodGroup());
        existing.setAvailable(member.getAvailable());

        return bloodDonorRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteBloodDonor(Long id) {
        if (!bloodDonorRepository.existsById(id)) {
            throw new RuntimeException("Blood Donor Member not found with id: " + id);
        }
        bloodDonorRepository.deleteById(id);
    }
}
