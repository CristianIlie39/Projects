package business.service;

import business.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AuthorDAO;
import persistence.entities.Author;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    AuthorDTO authorDTO = new AuthorDTO();

    public void insert(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setSurname(authorDTO.getSurname());
        author.setFirstName(authorDTO.getFirstName());
        authorDAO.insert(author);
    }

    public List<AuthorDTO> findByAll() {
        List<Author> authorListByAll = authorDAO.findByAll();
        List<AuthorDTO> authorDTOListByAll = new ArrayList<>();
        for (Author author : authorListByAll) {
            authorDTO.setSurname(author.getSurname());
            authorDTO.setFirstName(author.getFirstName());
            authorDTOListByAll.add(authorDTO);
        }
        return authorDTOListByAll;
    }

    public List<AuthorDTO> findBySurname(String surname) {
        List<Author> authorListBySurname = authorDAO.findBySurname(surname);
        List<AuthorDTO> authorDTOListBySurname = new ArrayList<>();
        for (Author author : authorListBySurname) {
            authorDTO.setSurname(author.getSurname());
            authorDTO.setFirstName(author.getFirstName());
            authorDTOListBySurname.add(authorDTO);
        }
        return authorDTOListBySurname;
    }

}
