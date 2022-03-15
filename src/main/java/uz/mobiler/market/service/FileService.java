package uz.mobiler.market.service;

import org.springframework.web.multipart.MultipartFile;
import uz.mobiler.market.dto.StoreFileResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileService {
    StoreFileResponse store(MultipartFile file) throws IOException;
    byte[] getFile(String uid) throws IOException;
}
