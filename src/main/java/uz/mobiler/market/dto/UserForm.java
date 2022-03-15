package uz.mobiler.market.dto;


import lombok.Data;
import uz.mobiler.market.entity.Category;

@Data
public class UserForm {
    private String fullName;
    private String username;
    private String password;
}
