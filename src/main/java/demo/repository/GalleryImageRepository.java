package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.entity.GalleryImage;

@Repository
public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {
}
