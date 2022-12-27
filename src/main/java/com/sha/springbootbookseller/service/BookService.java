package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Annance;
import com.sha.springbootbookseller.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 3.07.2021
 * @time 18:10
 */
@Service
public class BookService implements IBookService
{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public Annance saveBook(Annance book)
    {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Annance> findAllBooks()
    {
        return bookRepository.findAll();
    }
}
