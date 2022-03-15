package uz.mobiler.market.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Product extends BaseEntity {
    private String name;
    private int price;
    @ManyToOne
    private Category category;
    private String photoUid;
}
