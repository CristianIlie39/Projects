package entryPoint;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.PersonDTO;
import business.dto.SectionDTO;
import business.service.BookService;
import business.service.PersonService;
import business.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.dao.BookDAO;
import persistence.entities.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LibraryEntryPoint {

    @Autowired
    BookService bookService;

    @Autowired
    PersonService personService;

    @Autowired
    SectionService sectionService;

    public void run() {

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

        AuthorDTO authorDTO1 = new AuthorDTO("Duhigg", "Charles");
        AuthorDTO authorDTO2 = new AuthorDTO("Dezmir", "Luca");
        AuthorDTO authorDTO3 = new AuthorDTO("Bilic", "Mihaela");
        AuthorDTO authorDTO4 = new AuthorDTO("Burcas", "Eusebiu");
        AuthorDTO authorDTO5 = new AuthorDTO("Szekely", "Andy");

        Set<AuthorDTO> authorDTOSet1 = new HashSet<AuthorDTO>();
        authorDTOSet1.add(authorDTO1);

        Set<AuthorDTO> authorDTOSet2 = new HashSet<AuthorDTO>();
        authorDTOSet2.add(authorDTO2);

        Set<AuthorDTO> authorDTOSet3 = new HashSet<AuthorDTO>();
        authorDTOSet3.add(authorDTO2);
        authorDTOSet3.add(authorDTO4);
        authorDTOSet3.add(authorDTO5);

        Set<AuthorDTO> authorDTOSet4 = new HashSet<AuthorDTO>();
        authorDTOSet4.add(authorDTO3);

        SectionDTO sectionDTO1 = new SectionDTO("Dezvoltare personala", authorDTOSet3);
        SectionDTO sectionDTO2 = new SectionDTO("Sanatate", authorDTOSet4);

        BookDTO bookDTO1 = new BookDTO("Puterea obisnuintei", 1, true, sectionDTO1, authorDTOSet1);
        BookDTO bookDTO2 = new BookDTO("Mai tare ca banca", 1, true, sectionDTO2, authorDTOSet2);
        BookDTO bookDTO3 = new BookDTO("Iesi din labirint", 1, true, sectionDTO1, authorDTOSet3);
        BookDTO bookDTO4 = new BookDTO("Confesiuni gurmande", 1, false, sectionDTO2, authorDTOSet4);
        BookDTO bookDTO5 = new BookDTO("Supa de incalzit inima", 1, true, sectionDTO2, authorDTOSet4);


        //aici inseram cele 5 carti; se insereaza automat sectiunile si autorii aferenti celor 5 carti
        bookService.insert(bookDTO1);
        bookService.insert(bookDTO2);
        bookService.insert(bookDTO3);
        bookService.insert(bookDTO4);
        bookService.insert(bookDTO5);

        Set<BookDTO> bookDTOSet1 = new HashSet<BookDTO>();
        bookDTOSet1.add(bookDTO1);
        bookDTOSet1.add(bookDTO2);

        Set<AuthorDTO> authorDTOSet5 = new HashSet<AuthorDTO>();
        authorDTOSet5.add(authorDTO1);
        authorDTOSet5.add(authorDTO2);

        Set<SectionDTO> sectionDTOSet1 = new HashSet<SectionDTO>();
        sectionDTOSet1.add(sectionDTO1);

        PersonDTO personDTO1 = new PersonDTO("Mazilu", "Tudorel", "Galati", 30, bookDTOSet1, authorDTOSet5,
                sectionDTOSet1);

        //aici inseram persoana 1 cu cartile imprumutate, autorii si sectiunile aferente
        personService.insert(personDTO1);

        Set<BookDTO> bookDTOSet2 = new HashSet<BookDTO>();
        bookDTOSet2.add(bookDTO3);
        bookDTOSet2.add(bookDTO5);

        Set<AuthorDTO> authorDTOSet6 = new HashSet<AuthorDTO>();
        authorDTOSet6.add(authorDTO2);
        authorDTOSet6.add(authorDTO3);

        Set<SectionDTO> sectionDTOSet2 = new HashSet<SectionDTO>();
        sectionDTOSet2.add(sectionDTO1);
        sectionDTOSet2.add(sectionDTO2);

        //aici inseram persoana 2 cu cartile imprumutate, autorii si sectiunile aferente
        PersonDTO personDTO2 = new PersonDTO("Caramarin", "George", "Braila", 22, bookDTOSet2, authorDTOSet6, sectionDTOSet2);
        personService.insert(personDTO2);

        //aici introducem sectiuni cu cartile si autorii aferenti
        Set<BookDTO> bookDTOSetForSection1 = new HashSet<BookDTO>();
        bookDTOSetForSection1.add(bookDTO1);
        bookDTOSetForSection1.add(bookDTO2);
        bookDTOSetForSection1.add(bookDTO3);

        Set<AuthorDTO> authorDTOSetForSection1 = new HashSet<AuthorDTO>();
        authorDTOSetForSection1.add(authorDTO1);
        authorDTOSetForSection1.add(authorDTO2);
        authorDTOSetForSection1.add(authorDTO4);
        authorDTOSetForSection1.add(authorDTO5);

        SectionDTO newSectionDTO1 = new SectionDTO("Dezvoltare personala", bookDTOSetForSection1, authorDTOSetForSection1);
        sectionService.insert(newSectionDTO1);

        Set<BookDTO> bookDTOSetForSection2 = new HashSet<BookDTO>();
        bookDTOSetForSection2.add(bookDTO4);
        bookDTOSetForSection2.add(bookDTO5);

        Set<AuthorDTO> authorDTOSetForSection2 = new HashSet<AuthorDTO>();
        authorDTOSetForSection2.add(authorDTO3);

        SectionDTO newSectionDTO2 = new SectionDTO("Sanatate", bookDTOSetForSection2, authorDTOSetForSection2);
        sectionService.insert(newSectionDTO2);

        //sa se afiseze persoanele care au imprumutat carti cu varsta mai mica de 25 ani
        List<PersonDTO> personDTOList = personService.findByAge(25);
        System.out.println("Afisam persoanele cu varsta mai mica de 25 ani care au imprumutat carti");
        for (PersonDTO personDTO : personDTOList) {
            System.out.println(personDTO.toString());
        }

        //sa se afiseze dupa nume persoanele care au imprumutat carti
        String name = "Caramarin";
        List<PersonDTO> personDTOListByName = personService.findByName(name);
        System.out.println("Afisam persoanele cu numele Caramarin care au imprumutat carti");
        for (PersonDTO personDTO : personDTOListByName) {
            System.out.println(personDTO.toString());
        }

        //sa se afiseze cartile disponibile in biblioteca
        List<BookDTO> availableBookDTOList = bookService.findByBorrowed(false);
        System.out.println("Afisam cartile disponibile in biblioteca");
        for (BookDTO bookDTO : availableBookDTOList) {
            System.out.println(bookDTO.toString());
        }

        //sa se caute o carte dupa un titlu
        String title = "Mai tare ca banca";
        List<BookDTO> bookDTOListByTitle = bookService.findByTitle(title);
        for (BookDTO bookDTO : bookDTOListByTitle) {
            System.out.println(bookDTO.toString());
        }

        String title1 = "Puterea obisnuintei";
        List<BookDTO> bookDTOListByTitle2 = bookService.findByTitle(title1);
        for (BookDTO bookDTO : bookDTOListByTitle2) {
            System.out.println(bookDTO.toString());
        }

        //sa se afiseze cartile imprumutate
        List<BookDTO> bookDTOListByBorrowed = bookService.findByBorrowed(true);
        for (BookDTO bookDTO : bookDTOListByBorrowed) {
            System.out.println(bookDTO.toString());
        }

        //sa se gaseasca cartile scrise de un anumit autor
        List<BookDTO> bookDTOListByAuthor = bookService.findByAuthor("Dezmir");
        for (BookDTO bookDTO : bookDTOListByAuthor) {
            System.out.println(bookDTO.toString());
        }

        //8.sa se adauge o carte noua intr-o sectiune existenta
        BookDTO bookDTO6 = new BookDTO("Manual de guerilla fiscala", 1, false, sectionDTO1, authorDTOSet2);
        bookService.insert(bookDTO6);

        //9.inseram 2 carti noi si 2 persoane noi care le imprumuta -> sa se reprezinte relatia ManyToMany intre carti
        //si persoanele care le imprumuta

        Set<AuthorDTO> authorDTOSet7 = new HashSet<AuthorDTO>();
        authorDTOSet7.add(authorDTO5);

        BookDTO bookDTO7 = new BookDTO("Manifestul educatiei", 1, true, sectionDTO1, authorDTOSet7);
        BookDTO bookDTO8 = new BookDTO("Decizii radicale", 1, false, sectionDTO1, authorDTOSet7);

        PersonDTO personDTO3 = new PersonDTO("Marinescu", "Ion", "Iasi", 45);
        PersonDTO personDTO4 = new PersonDTO("Avram", "Constantin", "Bucuresti", 50);

        Set<BookDTO> bookDTOSet3 = new HashSet<BookDTO>();
        bookDTOSet3.add(bookDTO7);
        bookDTOSet3.add(bookDTO8);

        personDTO3.setBookDTOSet(bookDTOSet3);
        personDTO4.setBookDTOSet(bookDTOSet3);

        personService.insert(personDTO3);
        personService.insert(personDTO4);


    }

}
