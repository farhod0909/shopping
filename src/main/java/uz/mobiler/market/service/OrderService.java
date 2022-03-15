package uz.mobiler.market.service;

import org.springframework.web.multipart.MultipartFile;
import uz.mobiler.market.dto.StoreFileResponse;

import java.io.IOException;

interface OrderService{
    void addNew();
    void confirm();
    void pay();
}
