package com.decryptor.domain;


import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity (name ="GTIN")
@Table(name = "GTIN")
public class GTINEntity {

    @Id
    @Column(name = "GTIN")
    private String gtin;

    @NotNull
    @Column(name = "name")
    private String name;

}
