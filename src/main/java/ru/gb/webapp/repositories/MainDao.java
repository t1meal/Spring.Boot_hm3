package ru.gb.webapp.repositories;

import java.util.List;

public interface MainDao <T> {
    void save (T model);
    void deleteById (Long id) ;
    T findById(Long id) ;
    List<T> findAll ();
}
