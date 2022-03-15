package uz.mobiler.market.dto;

import lombok.Builder;
import lombok.Data;
import uz.mobiler.market.entity.Product;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private Long categoryId;
    private String photoUid;

    public static ProductDto toDto(Product e){
        return ProductDto
                .builder()
                .id(e.getId())
                .photoUid(e.getPhotoUid())
                .categoryId(e.getCategory().getId())
                .name(e.getName())
                .price(e.getPrice())
                .build();
    }
}
