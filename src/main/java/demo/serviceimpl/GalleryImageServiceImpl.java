package demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.GalleryImage;
import demo.repository.GalleryImageRepository;
import demo.service.GalleryImageServices;

@Service
public class GalleryImageServiceImpl implements GalleryImageServices {

    @Autowired
    private GalleryImageRepository galleryImageRepository;

    // GET ALL
    @Override
    public List<GalleryImage> getAllGalleryImages() {
        return galleryImageRepository.findAll();
    }

    // GET BY ID
    @Override
    public GalleryImage getGalleryImageById(Long id) {
        return galleryImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery Image not found with id: " + id));
    }

    // CREATE
    @Override
    public GalleryImage createNewGalleryImage(GalleryImage image) {
        return galleryImageRepository.save(image);
    }

    // UPDATE
    @Override
    public GalleryImage updateGalleryImage(Long id, GalleryImage image) {
        GalleryImage existing = galleryImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery Image not found with id: " + id));

        existing.setTitle(image.getTitle());
        existing.setPhotoUrl(image.getPhotoUrl());
        existing.setCategory(image.getCategory());

        return galleryImageRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteGalleryImage(Long id) {
        if (!galleryImageRepository.existsById(id)) {
            throw new RuntimeException("Gallery Image not found with id: " + id);
        }
        galleryImageRepository.deleteById(id);
    }
}
