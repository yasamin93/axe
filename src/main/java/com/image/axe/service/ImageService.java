package com.image.axe.service;

import com.image.axe.entity.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    public void save(Image image) {
        saveFile(image.getImage());
    }

    private void saveFile(MultipartFile multipartFile) {
        try {
            saveToFileSystem(multipartFile);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save file ", e);
        }
    }

    private static void saveToFileSystem(MultipartFile multipartFile) throws IOException {

        Path path = Paths.get("image-files");
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        String dir = path.toFile().getAbsolutePath();
        File file = new File(dir + "/" + multipartFile.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        System.out.println("Image stored in "+ file.getName());
    }
}
