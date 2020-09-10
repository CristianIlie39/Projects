package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findBookByTitle", query = "select book from Book book where book.title = :title"),
        @NamedQuery(name = "findBookByBorrowed", query = "select book from Book book where book.borrowed = :borrowed"),
        @NamedQuery(name = "findBookByAuthor", query = "select book from Book book inner join book.authorSet authors where authors.surname = :surname")
})

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "number_of_volumes")
    private int numberOfVolumes;

    @Column(name = "borrowed")
    private boolean borrowed;

    //cream relatia ManyToOne intre entitatile Book si Section
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sections_id")
    private Section section;

    //cream relatia ManyToMany intre entitatile Book si Author; Book este entitatea care initiaza operatiile de CRUD
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "books_id")}, //am mentionat care-i FK pt entitatea curenta - book, apoi am scris FK pt cealalta entitate - author
            inverseJoinColumns = {@JoinColumn(name = "authors_id")}
    )
    private Set<Author> authorSet;

    //In entitatea Person avem deja creata relatia Many To Many intre entitatile Book si Person
    //Entitatea Person este cea care initiaza operatiile de CRUD

    public Book(String title, int numberOfVolumes, boolean borrowed, Section section,
                Set<Author> authorSet) {
        this.title = title;
        this.numberOfVolumes = numberOfVolumes;
        this.borrowed = borrowed;
        this.section = section;
        this.authorSet = authorSet;
    }

    public Book(String title, int numberOfVolumes, boolean borrowed, Section section) {
        this.title = title;
        this.numberOfVolumes = numberOfVolumes;
        this.borrowed = borrowed;
        this.section = section;
    }

    public Book(String title) {
        this.title = title;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfVolumes() {
        return numberOfVolumes;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public Section getSection() {
        return section;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberOfVolumes(int numberOfVolumes) {
        this.numberOfVolumes = numberOfVolumes;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public String toString() {
        return this.title + " " + this.numberOfVolumes + " " + this.borrowed + " " + this.section + " " + this.authorSet;

    }

}
