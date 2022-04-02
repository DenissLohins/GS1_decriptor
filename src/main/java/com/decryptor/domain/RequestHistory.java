package com.decryptor.domain;

import javax.persistence.*;

@Table (name = "RequestHistory")
public class RequestHistory {
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
}
