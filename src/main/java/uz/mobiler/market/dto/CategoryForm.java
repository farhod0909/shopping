package uz.mobiler.market.dto;


import lombok.Data;
import uz.mobiler.market.entity.Category;

@Data
public class CategoryForm {
    private String name;
    private Long parentId;
}
