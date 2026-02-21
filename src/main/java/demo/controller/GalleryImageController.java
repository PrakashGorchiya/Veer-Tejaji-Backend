package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import demo.entity.GalleryImage;
import demo.repository.GalleryImageRepository;
import demo.service.ImageUploadService;
import demo.serviceimpl.GalleryImageServiceImpl;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*") // for React
public class GalleryImageController {

    @Autowired
    private GalleryImageServiceImpl galleryImageServiceImpl;
    
    @Autowired
    private GalleryImageRepository galleryImageRepository; 
    
    @Autowired
    private ImageUploadService imageUploadService; 

    // GET ALL
    @GetMapping
    public List<GalleryImage> getAllGalleryImages() {
        return galleryImageServiceImpl.getAllGalleryImages();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public GalleryImage getGalleryImageById(@PathVariable Long id) {
        return galleryImageServiceImpl.getGalleryImageById(id);
    }

    // CREATE
    @PostMapping
    public GalleryImage createNewGalleryImage(@RequestBody GalleryImage image) {
        return galleryImageServiceImpl.createNewGalleryImage(image);
    }
    
    @PostMapping("/with-image")
    public GalleryImage createGalleryImageWithImage(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam MultipartFile image) throws Exception {
        String imageUrl = imageUploadService.uploadImage(image);

        GalleryImage galleryImage = new GalleryImage();
        galleryImage.setTitle(title);
        galleryImage.setCategory(category);
        galleryImage.setPhotoUrl(imageUrl);

        return galleryImageRepository.save(galleryImage);
    }

    // UPDATE
    @PutMapping("/{id}")
    public GalleryImage updateGalleryImage(
            @PathVariable Long id,
            @RequestBody GalleryImage image) {
        return galleryImageServiceImpl.updateGalleryImage(id, image);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteGalleryImage(@PathVariable Long id) {
        galleryImageServiceImpl.deleteGalleryImage(id);
        return "Gallery Image deleted successfully";
    }
}
