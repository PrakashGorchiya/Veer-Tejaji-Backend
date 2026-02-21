package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import demo.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

}

