package com.decryptor.domain;

import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import javax.persistence.*;

@Data
@Entity (name = "request")
@Table (name = "RequestHistory")
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
    @Column (name = "productID")
    @Nullable
    private String productID;
}
