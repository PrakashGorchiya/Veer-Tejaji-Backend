package demo.service;

import java.util.List;
import demo.entity.CommitteeMember;

public interface CommitteMemberServices {

    List<CommitteeMember> getAllCommitteeMembers();

    CommitteeMember getCommitteeMemberById(Long id);

    CommitteeMember createNewCommitteeMember(CommitteeMember member);

    CommitteeMember updateCommitteeMember(Long id, CommitteeMember member);

    void deleteCommitteeMember(Long id);
}
