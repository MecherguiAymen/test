package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Annance;

import java.util.List;

/**
 * @author sa
 * @date 3.07.2021
 * @time 18:09
 */
public interface IBookService
{
    Annance saveBook(Annance book);

    void deleteBook(Long id);

    List<Annance> findAllBooks();
}
