package demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Donor;
import demo.repository.DonorRepository;
import demo.service.DonorServices;

@Service
public class DonorServicesImpl implements DonorServices {

    @Autowired
    private DonorRepository donorRepository;

    // GET ALL
    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    // GET BY ID
    @Override
    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor Member not found with id: " + id));
    }

    // CREATE
    @Override
    public Donor createNewDonor(Donor member) {
        return donorRepository.save(member);
    }

    // UPDATE
    @Override
    public Donor updateDonor(Long id, Donor member) {

        Donor existing = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor Member not found with id: " + id));

        existing.setName(member.getName());
        existing.setMobile(member.getMobile());
        existing.setCity(member.getCity());
        existing.setAmount(member.getAmount());
        existing.setMessage(member.getMessage());

        return donorRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("Donor Member not found with id: " + id);
        }
        donorRepository.deleteById(id);
    }
}
