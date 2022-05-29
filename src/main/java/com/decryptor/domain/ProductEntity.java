package com.decryptor.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;


@Data
@Entity (name ="ProductEntity")
@Table(name = "gtin")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "gtin", nullable = false)
    private String gtin;

    @NotNull
    @Column(name = "name")
    private String name;

}
