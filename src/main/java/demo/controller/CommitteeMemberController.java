package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import demo.entity.CommitteeMember;
import demo.repository.CommitteeMemberRepository;
import demo.service.ImageUploadService;
import demo.serviceimpl.CommitteeMemberServiceImpl;

@RestController
@RequestMapping("/api/committee")
@CrossOrigin(origins = "*") // for React
public class CommitteeMemberController {

    @Autowired
    private CommitteeMemberServiceImpl committeeMemberServiceImpl;
    
    @Autowired
    private CommitteeMemberRepository committeeMemberRepository; 
    
    @Autowired
    private ImageUploadService imageUploadService; 

    // GET ALL
    @GetMapping
    public List<CommitteeMember> getAllCommitteeMembers() {
        return committeeMemberServiceImpl.getAllCommitteeMembers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CommitteeMember getCommitteeMemberById(@PathVariable Long id) {
        return committeeMemberServiceImpl.getCommitteeMemberById(id);
    }

    // CREATE
    @PostMapping
    public CommitteeMember createNewCommitteeMember(@RequestBody CommitteeMember member) {
        return committeeMemberServiceImpl.createNewCommitteeMember(member);
    }
    
    @PostMapping("/with-image")
    public CommitteeMember createCommitteeMemberWithImage( @RequestParam String role, @RequestParam String name, @RequestParam String mobile, @RequestParam MultipartFile image) throws Exception {
        String imageUrl = imageUploadService.uploadImage(image);

        CommitteeMember member = new CommitteeMember();
        member.setRole(role);
        member.setName(name);
        member.setMobile(mobile);
        member.setPhotoUrl(imageUrl);

        return committeeMemberRepository.save(member);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CommitteeMember updateCommitteeMember(
            @PathVariable Long id,
            @RequestBody CommitteeMember member) {

        return committeeMemberServiceImpl.updateCommitteeMember(id, member);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCommitteeMember(@PathVariable Long id) {
        committeeMemberServiceImpl.deleteCommitteeMember(id);
        return "Committee Member deleted successfully";
    }
}
