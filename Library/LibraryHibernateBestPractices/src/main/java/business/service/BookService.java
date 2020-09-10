package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.BookDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    BookDAO bookDAO;

    public void insert(BookDTO bookDTO) {

        Set<Author> authorSet = new HashSet<>();
        for (AuthorDTO authorDTO : bookDTO.getAuthorDTOSet()) {
            Author author = new Author();
            author.setSurname(authorDTO.getSurname());
            author.setFirstName(authorDTO.getFirstName());
            authorSet.add(author);
        }
        Section section = new Section();
        section.setName(bookDTO.getSectionDTO().getName());
        section.setAuthorSet(authorSet);
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setNumberOfVolumes(bookDTO.getNumberOfVolumes());
        book.setBorrowed(bookDTO.isBorrowed());
        book.setSection(section);
        book.setAuthorSet(authorSet);
        bookDAO.insert(book);
    }

    public List<BookDTO> findByTitle(String title) {
        List<Book> bookListByTitle = bookDAO.findByTitle(title);
        List<BookDTO> bookDTOListByTitle = new ArrayList<>();
        for (Book book : bookListByTitle) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setNumberOfVolumes(book.getNumberOfVolumes());
            bookDTOListByTitle.add(bookDTO);
        }
        return bookDTOListByTitle;
    }


    public List<BookDTO> findByBorrowed(boolean borrowed) {
        List<Book> bookListByBorrowed = bookDAO.findByBorrowed(borrowed);
        List<BookDTO> bookDTOListByBorrowed = new ArrayList<>();
        for (Book book : bookListByBorrowed) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setNumberOfVolumes(book.getNumberOfVolumes());
            bookDTOListByBorrowed.add(bookDTO);
        }
        return bookDTOListByBorrowed;
    }

    public List<BookDTO> findByAuthor(String authorSurname) {
        List<Book> bookListByAuthor = bookDAO.findByAuthor(authorSurname);
        List<BookDTO> bookDTOListByAuthor = new ArrayList<>();
        for (Book book : bookListByAuthor) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setNumberOfVolumes(book.getNumberOfVolumes());
            bookDTOListByAuthor.add(bookDTO);
        }
        return bookDTOListByAuthor;
    }
}
