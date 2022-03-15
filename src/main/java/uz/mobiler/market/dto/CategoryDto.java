package uz.mobiler.market.dto;


import lombok.Data;
import uz.mobiler.market.entity.Category;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private Long parentId;

    public static CategoryDto toDto(Category e) {
        CategoryDto dto = new CategoryDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        if (e.getParentCategory() != null) {
            dto.setParentId(e.getParentCategory().getId());
        }
        return dto;
    }
}
