package demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Volunteer;
import demo.repository.VolunteerRepository;
import demo.service.VolunteerServices;

@Service
public class VolunteerServiceImpl implements VolunteerServices {

    @Autowired
    private VolunteerRepository volunteerRepository;

    // GET ALL
    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    // GET BY ID
    @Override
    public Volunteer getVolunteerById(Long id) {
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer Member not found with id: " + id));
    }

    // CREATE
    @Override
    public Volunteer createNewVolunteer(Volunteer member) {
        return volunteerRepository.save(member);
    }

    // UPDATE
    @Override
    public Volunteer updateVolunteer(Long id, Volunteer member) {

        Volunteer existing = volunteerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer Member not found with id: " + id));

        existing.setName(member.getName());
        existing.setMobile(member.getMobile());
        existing.setCity(member.getCity());
        existing.setArea(member.getArea());
        existing.setActive(member.getActive());

        return volunteerRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteVolunteer(Long id) {
        if (!volunteerRepository.existsById(id)) {
            throw new RuntimeException("Volunteer Member not found with id: " + id);
        }
        volunteerRepository.deleteById(id);
    }
}
