package com.decryptor.repository;


import java.util.List;
import java.util.Optional;

public interface HibernateRepository<T> {

    T save(T entity);

    T update (T entity);

    List<T> getAll();

}
