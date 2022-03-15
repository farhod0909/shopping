package uz.mobiler.market.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.mobiler.market.enums.UserRole;

import javax.persistence.*;

@Data
@Entity
@Table(name = "my_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    @Column(unique = true, length = 64)
    private String username;
    @Column(length = 128)
    private String fullName;
    private String password;
    private boolean blocked;
    @Enumerated(EnumType.STRING) @Column(length = 32)
    private UserRole role;
}
