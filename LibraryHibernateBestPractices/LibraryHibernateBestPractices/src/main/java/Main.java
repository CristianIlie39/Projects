import persistence.dao.BookDAO;
import persistence.dao.PersonDAO;
import persistence.dao.SectionDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Person;
import persistence.entities.Section;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //1.sa se insereze 5 carti scrise de 5 autori (cel putin una din carti sa fie scrisa de mai multi autori); cele 5 carti fac parte din 2 sectiuni diferite, iar 2 persoane au imprumutat 4 dintre cele 5 carti
        //2.sa se afiseze persoanele care au imprumutat carti cu varsta mai mica de 25 ani
        //3.sa se afiseze dupa nume o persoana care a imprumutat carti
        //4.sa se afiseze cartile imprumutate
        //5.sa se afiseze cartile disponibile in biblioteca
        //6.sa se caute o carte dupa un titlu
        //7.sa se gaseasca cartile scrise de un anumit autor
        //8.sa se adauge o carte noua intr-o sectiune existenta
        //9.inseram 2 carti noi si 2 persoane noi care le imprumuta -> sa se reprezinte relatia ManyToMany intre carti si persoanele care le imprumuta


        //1.sa se insereze 5 carti scrise de 3 autori; cele 5 carti fac parte din 3 sectiuni diferite, iar 2 persoane au imprumutat 4 dintre cele 5 carti

        Author author1 = new Author("Duhigg", "Charles");
        Author author2 = new Author("Dezmir", "Luca");
        Author author3 = new Author("Bilic", "Mihaela");
        Author author4 = new Author("Burcas", "Eusebiu");
        Author author5 = new Author("Szekely", "Andy");

        Set<Author> authorSet1 = new HashSet<Author>();
        authorSet1.add(author1);

        Set<Author> authorSet2 = new HashSet<Author>();
        authorSet2.add(author2);

        Set<Author> authorSet3 = new HashSet<Author>();
        authorSet3.add(author2);
        authorSet3.add(author4);
        authorSet3.add(author5);

        Set<Author> authorSet4 = new HashSet<Author>();
        authorSet4.add(author3);

        Section section1 = new Section("Dezvoltare personala");
        Section section2 = new Section("Sanatate");

        Book book1 = new Book("Puterea obisnuintei", 1, true, section1, authorSet1);
        Book book2 = new Book("Mai tare ca banca", 1, true, section1, authorSet2);
        Book book3 = new Book("Iesi din labirint", 1, true, section1, authorSet3);
        Book book4 = new Book("Confesiuni gurmande", 1, false, section2, authorSet4);
        Book book5 = new Book("Supa de incalzit inima", 1, true, section2, authorSet4);

        //aici inseram cele 5 carti; se insereaza automat sectiunile si autorii aferenti celor 5 carti
        BookDAO bookDAO = new BookDAO();
        bookDAO.insert(book1);
        bookDAO.insert(book2);
        bookDAO.insert(book3);
        bookDAO.insert(book4);
        bookDAO.insert(book5);

        Set<Book> bookSet1 = new HashSet<Book>();
        bookSet1.add(book1);
        bookSet1.add(book2);

        Set<Author> authorSet5 = new HashSet<Author>();
        authorSet5.add(author1);
        authorSet5.add(author2);

        Set<Section> sectionSet1 = new HashSet<Section>();
        sectionSet1.add(section1);

        Person person1 = new Person("Mazilu", "Tudorel", "Galati", 30, bookSet1, authorSet5,
                sectionSet1);

        //aici inseram persoana 1 cu cartile imprumutate, autorii si sectiunile aferente
        PersonDAO personDAO = new PersonDAO();
        personDAO.insert(person1);

        Set<Book> bookSet2 = new HashSet<Book>();
        bookSet2.add(book3);
        bookSet2.add(book5);

        Set<Author> authorSet6 = new HashSet<Author>();
        authorSet6.add(author2);
        authorSet6.add(author3);

        Set<Section> sectionSet2 = new HashSet<Section>();
        sectionSet2.add(section1);
        sectionSet2.add(section2);

        //aici inseram persoana 2 cu cartile imprumutate, autorii si sectiunile aferente
        Person person2 = new Person("Caramarin", "George", "Braila", 22, bookSet2, authorSet6, sectionSet2);
        personDAO.insert(person2);

        //aici introducem sectiuni cu cartile si autorii aferenti
        Set<Book> bookSetForSection1 = new HashSet<Book>();
        bookSetForSection1.add(book1);
        bookSetForSection1.add(book2);
        bookSetForSection1.add(book3);

        Set<Author> authorSetForSection1 = new HashSet<Author>();
        authorSetForSection1.add(author1);
        authorSetForSection1.add(author2);
        authorSetForSection1.add(author4);
        authorSetForSection1.add(author5);

        Section newSection1 = new Section("Dezvoltare personala", bookSetForSection1, authorSetForSection1);
        SectionDAO sectionDAO = new SectionDAO();
        sectionDAO.insert(newSection1);

        Set<Book> bookSetForSection2 = new HashSet<Book>();
        bookSetForSection2.add(book4);
        bookSetForSection2.add(book5);

        Set<Author> authorSetForSection2 = new HashSet<Author>();
        authorSetForSection2.add(author3);

        Section newSection2 = new Section("Sanatate", bookSetForSection2, authorSetForSection2);
        sectionDAO.insert(newSection2);

        //2.sa se afiseze persoanele care au imprumutat carti cu varsta mai mica de 25 ani
        List<Person> personList = personDAO.findByAge(25);
        System.out.println("Afisam persoanele cu varsta mai mica de 25 ani care au imprumutat carti");
        for (Person person : personList) {
            System.out.println(person);
        }

        //3.sa se afiseze dupa nume persoanele care au imprumutat carti
        String name = "Caramarin";
        List<Person> personListByName = personDAO.findByName(name);
        System.out.println("Afisam persoanele cu numele Caramarin care au imprumutat carti");
        for (Person person : personListByName) {
            System.out.println(person);
        }

        //4.sa se afiseze cartile imprumutate
        List<Book> borrowedBookList = bookDAO.findByBorrowed(true);
        System.out.println("Afisam cartile imprumutate");
        for (Book book : borrowedBookList) {
            System.out.println(book);
        }

        //5.sa se afiseze cartile disponibile in biblioteca
        List<Book> availableBookList = bookDAO.findByBorrowed(false);
        System.out.println("Afisam cartile disponibile in biblioteca");
        for (Book book : availableBookList) {
            System.out.println(book);
        }

        //6.sa se caute o carte dupa un titlu
        String title = "Mai tare ca banca";
        List<Book> bookListByTitle = bookDAO.findByTitle(title);
        for (Book book : bookListByTitle) {
            System.out.println(book);
        }

        //7.sa se gaseasca cartile acrise de un anumit autor
        String authorSurname = "Duhigg";
        List<Book> bookListByAuthorSurname = bookDAO.findByAuthor(authorSurname);
        System.out.println("Afisam cartile scrise de autorul cu numele de familie Duhigg");
        for (Book book : bookListByAuthorSurname) {
            System.out.println(book);
        }

        //8.sa se adauge o carte noua intr-o sectiune existenta
        Book book6 = new Book("Manual de guerilla fiscala", 1, false, section1, authorSet2);
        bookDAO.insert(book6);

        //9.inseram 2 carti noi si 2 persoane noi care le imprumuta -> sa se reprezinte relatia ManyToMany intre carti
        // si persoanele care le imprumuta

        Set<Author> authorSet7 = new HashSet<Author>();
        authorSet7.add(author5);

        Book book7 = new Book("Manifestul educatiei", 1, true, section1, authorSet7);
        Book book8 = new Book("Decizii radicale", 1, false, section1, authorSet7);

        Person person3 = new Person("Marinescu", "Ion", "Iasi", 45);
        Person person4 = new Person("Avram", "Constantin", "Bucuresti", 50);

        Set<Book> bookSet3 = new HashSet<Book>();
        bookSet3.add(book7);
        bookSet3.add(book8);

        person3.setBookSet(bookSet3);
        person4.setBookSet(bookSet3);

        personDAO.insert(person3);
        personDAO.insert(person4);
    }
}
