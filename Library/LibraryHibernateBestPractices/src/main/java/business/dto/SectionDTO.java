package business.dto;

import java.util.Set;

public class SectionDTO {

    public String name;
    public Set<BookDTO> bookDTOSet;
    public Set<AuthorDTO> authorDTOSet;

    public SectionDTO(String name, Set<BookDTO> bookDTOSet, Set<AuthorDTO> authorDTOSet) {
        this.name = name;
        this.bookDTOSet = bookDTOSet;
        this.authorDTOSet = authorDTOSet;
    }

    public SectionDTO(String name, Set<AuthorDTO> authorDTOSet) {
        this.name = name;
        this.authorDTOSet = authorDTOSet;
    }

    public SectionDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookDTO> getBookDTOSet() {
        return bookDTOSet;
    }

    public void setBookDTOSet(Set<BookDTO> bookDTOSet) {
        this.bookDTOSet = bookDTOSet;
    }

    public Set<AuthorDTO> getAuthorDTOSet() {
        return authorDTOSet;
    }

    public void setAuthorDTOSet(Set<AuthorDTO> authorDTOSet) {
        this.authorDTOSet = authorDTOSet;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
