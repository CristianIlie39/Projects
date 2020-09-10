package persistence.entities;

import org.hibernate.usertype.UserCollectionType;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findSectionByName", query = "select section from Section section where section.name = :name")
})

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    //cream relatia OneToMany intre entitatile Section si Book
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    //cream relatia ManyToMany intre entitatile Section si Author; Section este entitatea care initiaza operatiile de CRUD
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "authors_sections",
            joinColumns = {@JoinColumn(name = "sections_id")},
            inverseJoinColumns = {@JoinColumn(name = "authors_id")}
    )
    private Set<Author> authorSet;

    //In entiatatea Person avem jeja creata realatia ManyToMany intre entiatatile Section si Person
    //Person este entitatea care initiaza operatiile de CRUD

    public Section(String name, Set<Book> bookSet, Set<Author> authorSet) {
        this.name = name;
        this.bookSet = bookSet;
        this.authorSet = authorSet;
    }

    public Section(String name) {
        this.name = name;
    }

    public Section() {

    }

    public String getName() {
        return name;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public String toString() {
        return this.name;
    }

}
