package business.dto;

import persistence.entities.Author;
import persistence.entities.Section;

import java.util.Set;

public class BookDTO {

    private String title;
    private int numberOfVolumes;
    private boolean borrowed;
    private SectionDTO sectionDTO;
    private Set<AuthorDTO> authorDTOSet;

    public BookDTO(String title, int numberOfVolumes, boolean borrowed, SectionDTO sectionDTO, Set<AuthorDTO> authorDTOSet) {
        this.title = title;
        this.numberOfVolumes = numberOfVolumes;
        this.borrowed = borrowed;
        this.sectionDTO = sectionDTO;
        this.authorDTOSet = authorDTOSet;
    }

    public BookDTO(String title) {
        this.title = title;
    }

    public BookDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfVolumes() {
        return numberOfVolumes;
    }

    public void setNumberOfVolumes(int numberOfVolumes) {
        this.numberOfVolumes = numberOfVolumes;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public SectionDTO getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(SectionDTO sectionDTO) {
        this.sectionDTO = sectionDTO;
    }

    public Set<AuthorDTO> getAuthorDTOSet() {
        return authorDTOSet;
    }

    public void setAuthorDTOSet(Set<AuthorDTO> authorDTOSet) {
        this.authorDTOSet = authorDTOSet;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", numberOfVolumes=" + numberOfVolumes +
                '}';
    }
}
