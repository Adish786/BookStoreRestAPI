package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Book;

@Transactional
@Repository
public class BookStoreDAO implements IBookStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks() {
		
		String hql = "FROM Book as atcl ORDER BY atcl.id";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Book getBook(int bookId) {
		
		return entityManager.find(Book.class, bookId);
	}
	@Override
	public Book createBook(Book book) {
		entityManager.persist(book);
		Book b = getLastInsertedBook();
		return b;
	}
	
	@Override
	public Book updateBook(int bookId, Book book) {
		
	
		Book bookFromDB = getBook(bookId);
		bookFromDB.setName(book.getName());
		bookFromDB.setAuthor(book.getAuthor());
		bookFromDB.setCategory(book.getCategory());
		bookFromDB.setPublication(book.getPublication());
		bookFromDB.setPages(book.getPages());
		bookFromDB.setPrice(book.getPrice());
		
		entityManager.flush();
		
		Book updatedBook = getBook(bookId);
		
		return updatedBook;
	}
	
	@Override
	public boolean deleteBook(int bookId) {
		Book book = getBook(bookId);
		entityManager.remove(book);
		
		boolean status = entityManager.contains(book);
		if(status){
			return false;
		}
		return true;
	}
	private Book getLastInsertedBook(){
		String hql = "from Book order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Book book = (Book)query.getSingleResult();
		return book;
	}

}
