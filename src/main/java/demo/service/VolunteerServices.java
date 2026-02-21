package demo.service;

import java.util.List;

import demo.entity.Volunteer;

public interface VolunteerServices {

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(Long id);

    Volunteer createNewVolunteer(Volunteer volunteer);

    Volunteer updateVolunteer(Long id, Volunteer volunteer);

    void deleteVolunteer(Long id);
}
