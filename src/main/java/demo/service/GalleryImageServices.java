package demo.service;

import java.util.List;
import demo.entity.GalleryImage;

public interface GalleryImageServices {

    List<GalleryImage> getAllGalleryImages();

    GalleryImage getGalleryImageById(Long id);

    GalleryImage createNewGalleryImage(GalleryImage image);

    GalleryImage updateGalleryImage(Long id, GalleryImage image);

    void deleteGalleryImage(Long id);
}
