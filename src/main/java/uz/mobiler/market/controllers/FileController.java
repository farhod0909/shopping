package uz.mobiler.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.mobiler.market.dto.StoreFileResponse;
import uz.mobiler.market.service.FileService;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileService service;

    @GetMapping(value = "/{uid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFile(@PathVariable String uid) throws IOException {
       return service.getFile(uid);
    }

    @PostMapping
    public StoreFileResponse saveFile(@RequestParam MultipartFile file) throws IOException {
        return service.store(file);
    }


}
