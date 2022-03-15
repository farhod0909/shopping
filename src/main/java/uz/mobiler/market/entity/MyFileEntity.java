package uz.mobiler.market.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class MyFileEntity extends BaseEntity{
    private String url;
    private String fileName;
    private String uid;
    private String contentType;
    private Long size;
}
