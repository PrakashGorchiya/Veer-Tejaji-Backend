package demo.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    String uploadImage(MultipartFile file) throws IOException;
}
