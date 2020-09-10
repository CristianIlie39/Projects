package business.service;

import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.SectionDAO;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    SectionDAO sectionDAO;

    public void insert(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setName(sectionDTO.getName());
        sectionDAO.insert(section);
    }

    public List<SectionDTO> findByName(String nameSection) {
        List<Section> sectionListByName = sectionDAO.findByName(nameSection);
        List<SectionDTO> sectionDTOListByName = new ArrayList<>();
        for (Section section : sectionListByName) {
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setName(section.getName());
            sectionDTOListByName.add(sectionDTO);
        }
        return sectionDTOListByName;
    }

}
