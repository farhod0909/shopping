package uz.mobiler.market.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@Entity
public class Category extends BaseEntity {

    @Column(length = 128)
    private String name;

    @ManyToOne
    private Category parentCategory;

    @Column(columnDefinition = "TEXT")
    private String photo;

}
