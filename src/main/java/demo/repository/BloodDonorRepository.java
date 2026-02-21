package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import demo.entity.BloodDonor;

public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long>{

}
