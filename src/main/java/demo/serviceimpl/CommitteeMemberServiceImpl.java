package demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.CommitteeMember;
import demo.repository.CommitteeMemberRepository;
import demo.service.CommitteMemberServices;

@Service
public class CommitteeMemberServiceImpl implements CommitteMemberServices {

    @Autowired
    private CommitteeMemberRepository committeeMemberRepository;

    // GET ALL
    @Override
    public List<CommitteeMember> getAllCommitteeMembers() {
        return committeeMemberRepository.findAll();
    }

    // GET BY ID
    @Override
    public CommitteeMember getCommitteeMemberById(Long id) {
        return committeeMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Committee Member not found with id: " + id));
    }

    // CREATE
    @Override
    public CommitteeMember createNewCommitteeMember(CommitteeMember member) {
        return committeeMemberRepository.save(member);
    }

    // UPDATE
    @Override
    public CommitteeMember updateCommitteeMember(Long id, CommitteeMember member) {

        CommitteeMember existing = committeeMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Committee Member not found with id: " + id));

        existing.setRole(member.getRole());
        existing.setName(member.getName());
        existing.setMobile(member.getMobile());
        existing.setPhotoUrl(member.getPhotoUrl());

        return committeeMemberRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteCommitteeMember(Long id) {
        if (!committeeMemberRepository.existsById(id)) {
            throw new RuntimeException("Committee Member not found with id: " + id);
        }
        committeeMemberRepository.deleteById(id);
    }
}
