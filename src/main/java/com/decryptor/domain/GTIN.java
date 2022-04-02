package com.decryptor.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GTIN")
 class GTIN {

    @Id
    @Column (name = "GTIN", length = 15)
    private String gtin;

    @Column (name = "Name", length = 255)
    private String name;

}
