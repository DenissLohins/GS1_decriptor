package com.decryptor.domain;


import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
@Data
@Entity (name ="GTIN")
@Table(name = "gtin")
public class ProductEntity {

    @Id
    @Column(name = "gtin", nullable = false)
    private String gtin;

    @NotNull
    @Column(name = "name")
    private String name;

}
