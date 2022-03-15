package uz.mobiler.market.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.mobiler.market.dto.StoreFileResponse;
import uz.mobiler.market.entity.MyFileEntity;
import uz.mobiler.market.repository.FileRepository;
import uz.mobiler.market.service.FileService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {
    private final FileRepository repository;
//    Path rootPath = Paths.get("C://my-ap/my-app/files");



    @Override
    public StoreFileResponse store(MultipartFile file) throws IOException {
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        if (file.getOriginalFilename().contains(".."))
            throw new RuntimeException("File name is invalid!");
        String fileName = uid + file.getOriginalFilename().replaceAll(" ", "");
        Files.copy(file.getInputStream(), Path.of(fileName));
        MyFileEntity fileEntity = new MyFileEntity();
        fileEntity.setUid(uid);
        fileEntity.setUrl(fileName);
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setSize(file.getSize() / 1024);
        fileEntity.setContentType(file.getContentType());
        repository.save(fileEntity);
        return new StoreFileResponse(uid);
    }

    @Override
    public byte[] getFile(String uid) throws IOException {
        MyFileEntity fileInfo = repository.findByUidAndDeletedFalse(uid).orElseThrow(()-> new RuntimeException("File not found: "+ uid));
        return Files.readAllBytes(Path.of(fileInfo.getUrl()));
    }

}
