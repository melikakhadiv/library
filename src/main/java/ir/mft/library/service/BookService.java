package ir.mft.library.service;

import ir.mft.library.doa.BookDao;
import ir.mft.library.doa.UserDao;
import ir.mft.library.entity.Book;
import ir.mft.library.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private BookDao bookDao;
    private UserDao userDao;

    public BookService(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public Book findById(Long id){
        return bookDao.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
    }

    public Book save(Book book){
        return bookDao.save(book);
    }

    @Transactional
    public Book edit(Book book){
        return bookDao.save(book);
    }

    public void delete(Long id){
        bookDao.deleteById(id);
    }

    public Book borrow(Long bookId , Long userId){
        Book book = findById(bookId);
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User: " + userId + "Not Found!"));
        if (!book.isAvailable()) {
            throw new RuntimeException("Book: " + bookId + "is Not Available!");
        }
        book.setAvailable(false);
        book.setBorrowedBy(user);
        return bookDao.save(book);
        }
    }

