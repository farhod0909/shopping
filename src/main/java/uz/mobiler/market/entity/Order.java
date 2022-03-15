package uz.mobiler.market.entity;

import uz.mobiler.market.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "my_order")
public class Order extends BaseEntity{
    @OneToMany
    private List<OrderProduct> products;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 64)
    private OrderStatus status;
    private Long price;
}
