package com.example.imageserver.image;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageController {

    @Value("${images.upload-root")
    private String imageRoot;

    private final ImageStorageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        String imageId = imageService.store(file);
        return ResponseEntity.ok(imageId);
    }

    @GetMapping("/view/{imageId}")
    public ResponseEntity<Resource> getImage(@PathVariable("imageId") String imageId,
                                             @RequestParam(value = "thumbnail", defaultValue = "false") Boolean isThumbnail) {
        Resource image = imageService.get(imageId, isThumbnail);
        return (image != null) ? ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpeg")).body(image) : ResponseEntity.notFound().build();
    }
}
