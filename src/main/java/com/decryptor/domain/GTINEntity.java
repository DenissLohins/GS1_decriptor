package com.decryptor.domain;


import lombok.Data;
import javax.persistence.*;
@Data
@Entity (name ="GTIN")
@Table(name = "GTIN")
public class GTINEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "GTIN")
    private String gtin;

    @Column(name = "name")
    private String name;

}
