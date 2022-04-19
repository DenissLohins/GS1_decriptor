package com.decryptor.domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
@Data
@Entity (name = "request")
@Table (name = "RequestHistory")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column (name = "date")
    private String date;

    @Column (name = "time")
    private String time;

    @Column (name = "request")
    private String request;

    @Column (name = "productID")
    @Nullable
    private Integer productID;
}
