package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.entity.Donor;
import demo.repository.DonorRepository;
import demo.service.ImageUploadService;
import demo.serviceimpl.DonorServicesImpl;

@RestController
@RequestMapping("/api/donor")
@CrossOrigin(origins = "*") // for React
public class DonorController {

    @Autowired
    private DonorServicesImpl donorServicesImpl;
    
    @Autowired
    private DonorRepository donorRepository; 
    
    @Autowired
    private ImageUploadService imageUploadService; 
    
    // GET ALL
    @GetMapping
    public List<Donor> getAllDonors() {
        return donorServicesImpl.getAllDonors();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable Long id) {
        return donorServicesImpl.getDonorById(id);
    }

    // CREATE
    @PostMapping
    public Donor createNewDonor(@RequestBody Donor member) {
        return donorServicesImpl.createNewDonor(member);
    }
    
//    @PostMapping("/with-image")
//    public Donor createDonorWithImage( @RequestParam String role, @RequestParam String name, @RequestParam String mobile, @RequestParam MultipartFile image) throws Exception {
//        String imageUrl = imageUploadService.uploadImage(image);
//
//        Donor member = new Donor();
//        member.setName(name);
//        member.setMobile(mobile);
//        member.setPhotoUrl(imageUrl);
//
//        return donorRepository.save(member);
//    }

    // UPDATE
    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor member) {
        return donorServicesImpl.updateDonor(id, member);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
    	donorServicesImpl.deleteDonor(id);
        return "Donor deleted successfully";
    }
}
