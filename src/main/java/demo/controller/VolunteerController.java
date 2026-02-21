package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.entity.Volunteer;
import demo.repository.VolunteerRepository;
import demo.service.ImageUploadService;
import demo.serviceimpl.VolunteerServiceImpl;

@RestController
@RequestMapping("/api/Volunteer")
@CrossOrigin(origins = "*") // for React
public class VolunteerController {

    @Autowired
    private VolunteerServiceImpl volunteerServicesImpl;
    
    @Autowired
    private VolunteerRepository volunteerRepository; 
    
    @Autowired
    private ImageUploadService imageUploadService; 
    
    // GET ALL
    // @GetMapping
    // public List<Volunteer> getAllVolunteers() {
    //     return volunteerServicesImpl.getAllVolunteers();
    // }
    
    @GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        try {
            List<Volunteer> volunteers = volunteerServicesImpl.getAllVolunteers();
            return ResponseEntity.ok(volunteers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(0)).build();
        }
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return volunteerServicesImpl.getVolunteerById(id);
    }

    // CREATE
    @PostMapping
    public Volunteer createNewVolunteer(@RequestBody Volunteer member) {
        return volunteerServicesImpl.createNewVolunteer(member);
    }
    
//    @PostMapping("/with-image")
//    public Volunteer createVolunteerWithImage( @RequestParam String role, @RequestParam String name, @RequestParam String mobile, @RequestParam MultipartFile image) throws Exception {
//        String imageUrl = imageUploadService.uploadImage(image);
//
//        Volunteer member = new Volunteer();
//        member.setName(name);
//        member.setMobile(mobile);
//        member.setPhotoUrl(imageUrl);
//
//        return volunteerRepository.save(member);
//    }

    // UPDATE
    @PutMapping("/{id}")
    public Volunteer updateVolunteer(@PathVariable Long id, @RequestBody Volunteer member) {
        return volunteerServicesImpl.updateVolunteer(id, member);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteVolunteer(@PathVariable Long id) {
    	volunteerServicesImpl.deleteVolunteer(id);
        return "Volunteer deleted successfully";
    }
}
