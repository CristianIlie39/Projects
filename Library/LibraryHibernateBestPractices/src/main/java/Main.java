import config.SpringConfiguration;
import entryPoint.LibraryEntryPoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        LibraryEntryPoint libraryEntryPoint = annotationConfigApplicationContext.getBean(LibraryEntryPoint.class);
        libraryEntryPoint.run();

    }
}
