package com.decryptor.domain;


import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity (name ="GTIN")
@Table(name = "gtin")
public class GTINEntity {

    @Id
    @Column(name = "gtin")
    private String gtin;

    @NotNull
    @Column(name = "name")
    private String name;

}
