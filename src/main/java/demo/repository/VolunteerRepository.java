package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import demo.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}

