package com.decryptor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "request")
@Table (name = "request_history")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Order(1)
    @Column(name = "ID")
    private Integer id;

    @Order(2)
    @Column (name = "date")
    private String date;

    @Order(3)
    @Column (name = "time")
    private String time;

    @Order(4)
    @Column (name = "request")
    private String request;

    @Order(5)
    @Column (name = "product_id")
    @Nullable
    private String productID;
}
