package demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gallery_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // Optional title/description
    private String photoUrl;     // Cloudinary image URL
    private String category;     // Optional category (e.g., "Events", "Activities", etc.)
}
