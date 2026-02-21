package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.entity.BloodDonor;
import demo.repository.BloodDonorRepository;
import demo.service.ImageUploadService;
import demo.serviceimpl.BloodDonorServiceImpl;

@RestController
@RequestMapping("/api/BloodDonor")
@CrossOrigin(origins = "*") // for React
public class BloodDonorController {

    @Autowired
    private BloodDonorServiceImpl bloodDonorServicesImpl;
    
    @Autowired
    private BloodDonorRepository bloodDonorRepository; 
    
    @Autowired
    private ImageUploadService imageUploadService; 
    
    // GET ALL
    @GetMapping
    public List<BloodDonor> getAllBloodDonors() {
        return bloodDonorServicesImpl.getAllBloodDonors();
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public BloodDonor getBloodDonorById(@PathVariable Long id) {
        return bloodDonorServicesImpl.getBloodDonorById(id);
    }

    // CREATE
    @PostMapping
    public BloodDonor createNewBloodDonor(@RequestBody BloodDonor member) {
        return bloodDonorServicesImpl.createNewBloodDonor(member);
    }
    
//    @PostMapping("/with-image")
//    public BloodDonor createBloodDonorWithImage( @RequestParam String role, @RequestParam String name, @RequestParam String mobile, @RequestParam MultipartFile image) throws Exception {
//        String imageUrl = imageUploadService.uploadImage(image);
//
//        BloodDonor member = new BloodDonor();
//        member.setName(name);
//        member.setMobile(mobile);
//        member.setPhotoUrl(imageUrl);
//
//        return BloodDonorRepository.save(member);
//    }

    // UPDATE
    @PutMapping("/{id}")
    public BloodDonor updateBloodDonor(@PathVariable Long id, @RequestBody BloodDonor member) {
        return bloodDonorServicesImpl.updateBloodDonor(id, member);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBloodDonor(@PathVariable Long id) {
    	bloodDonorServicesImpl.deleteBloodDonor(id);
        return "BloodDonor deleted successfully";
    }
}
