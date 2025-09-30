package com.product.entity;

import jakarta.persistence.*;
import jakarta.websocket.OnMessage;
import lombok.Data;

@Entity(name="inventory")
@Data
public class Inventory {

    @Id
    private int product_id;

    @OneToOne
    @MapsId
    @JoinColumn(name="product_id")
    private Product product;

    private Integer quality_available;
    private Integer reserved_quantity;
    private Integer low_stock_threshold;


}
