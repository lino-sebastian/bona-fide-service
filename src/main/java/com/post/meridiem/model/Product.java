package com.post.meridiem.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Long productStock;
    private String currency;
    private String productImgThumb;
}
