package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.entity.CommitteeMember;

public interface CommitteeMemberRepository extends JpaRepository<CommitteeMember, Long> {
}

