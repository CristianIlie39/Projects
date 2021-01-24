package business.service;

import business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class AirportService {

    @Autowired
    AirportDAO airportDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insert(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setName(airportDTO.getName());
        setCity(airportDTO, airport);
        setFlightSet(airportDTO, airport);
        airportDAO.insert(airport);
    }

    //aici setez orasul pt a-l folosi in metoda insert de mai sus
    public void setCity(AirportDTO airportDTO, Airport airport) {
        City cityFound = cityDAO.findCityByName(airportDTO.getCityDTO().getName());
        if (cityFound != null) {
            airport.setCity(cityFound);
        } else {
            City city = new City();
            city.setName(airportDTO.getCityDTO().getName());
            setCountry(airportDTO, city);
            airport.setCity(city);
        }
    }

    //aici setez tara pt a o folosi in metoda setCity de ami sus
    public void setCountry(AirportDTO airportDTO, City city) {
        Country countryFound = countryDAO.findCountryByName(airportDTO.getCityDTO().getCountryDTO().getName());
        if (countryFound != null) {
            city.setCountry(countryFound);
        } else {
            Country country = new Country();
            country.setName(airportDTO.getCityDTO().getCountryDTO().getName());
            setContinent(airportDTO,country);
            city.setCountry(country);
        }
    }

    //aici setez continentul pt a-l folosi in metoda setCountry de mai sus
    public void setContinent(AirportDTO airportDTO, Country country) {
        Continent continentFound = continentDAO.findContinentByName(airportDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (continentFound != null) {
            country.setContinent(continentFound);
        } else {
            Continent continent = new Continent();
            continent.setName(airportDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setContinent(continent);
        }
    }

    //aici setez setul de zboruri pe aeroport pt al folosi in metoda insert de mai sus
    public void setFlightSet(AirportDTO airportDTO, Airport airport) {
        Set<Flight> flightSet = new HashSet<>();
        for (FlightDTO flightDTO : airportDTO.getFlightDTOSet()) {
            Flight flight = new Flight();
            flight.setFlightDepartureDate(flightDTO.getFlightDepartureDate());
            flight.setFlightDepartureTime(flightDTO.getFlightReturnTime());
            flight.setFlightReturnDate(flightDTO.getFlightReturnDate());
            flight.setFlightReturnTime(flightDTO.getFlightReturnTime());
            flight.setFlightTo(flightDTO.getFlightTo());
            flight.setPrice(flightDTO.getPrice());
            flight.setAvailableSeats(flightDTO.getAvailableSeats());
            flight.setAirport(airport);
            flightSet.add(flight);
        }
        airport.setFlightSet(flightSet);
    }

    public Long countAirport(String airportName, String cityName) {
        return airportDAO.countAirportByNameAndByCityName(airportName, cityName);
    }

    public AirportDTO findAirportByName(String airportName) {
        Airport airport = airportDAO.findAirportByName(airportName);
        if (airport == null) {
            return null;
        }
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(airport.getName());
        setCityDTO(airport, airportDTO);
        setFlightDTOSet(airport, airportDTO);
        return airportDTO;
    }

    //aici setez orasulDTO pt a-l folosi in metoda findAirportByName de mai sus
    public void setCityDTO(Airport airport, AirportDTO airportDTO) {
        City city = cityDAO.findCityByName(airport.getCity().getName());
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(city.getName());
        setCountryDTO(airport, cityDTO);
        airportDTO.setCityDTO(cityDTO);
    }

    //aici setez taraDTO pt a o folosi in metoda findAirportByName de mai sus
    public void setCountryDTO(Airport airport, CityDTO cityDTO) {
        Country country = countryDAO.findCountryByName(airport.getCity().getCountry().getName());
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        setContinentDTO(airport, countryDTO);
        cityDTO.setCountryDTO(countryDTO);
    }

    //aici setez continentulDTO pt a-l folosi in metoda findAirportByName de mai sus
    public void setContinentDTO(Airport airport, CountryDTO countryDTO) {
        Continent continent = continentDAO.findContinentByName(airport.getCity().getCountry().getContinent().getName());
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(continent.getName());
        countryDTO.setContinentDTO(continentDTO);
    }

    //aici setez setul de zboruriDTO pt a-l folosi in metoda findAirportByName de mai sus
    public void setFlightDTOSet(Airport airport, AirportDTO airportDTO) {
        Set<FlightDTO> flightDTOSet = new HashSet<>();
        for (Flight flight : airport.getFlightSet()) {
            FlightDTO flightDTO = new FlightDTO();
            flightDTO.setFlightDepartureDate(flight.getFlightDepartureDate());
            flightDTO.setFlightDepartureTime(flight.getFlightDepartureTime());
            flightDTO.setFlightReturnDate(flight.getFlightReturnDate());
            flightDTO.setFlightReturnTime(flight.getFlightReturnTime());
            flightDTO.setFlightTo(flight.getFlightTo());
            flightDTO.setPrice(flight.getPrice());
            flightDTO.setAvailableSeats(flight.getAvailableSeats());
            flightDTOSet.add(flightDTO);
        }
        airportDTO.setFlightDTOSet(flightDTOSet);
    }

    public List<AirportDTO> findAirportsByCityName(String cityName) {
        List<Airport> airportList = airportDAO.findAirportsByCityName(cityName);
        List<AirportDTO> airportDTOList = new LinkedList<>();
        for (Airport airport : airportList) {
            AirportDTO airportDTO = new AirportDTO();
            airportDTO.setName(airport.getName());
            setCityDTO(airport, airportDTO);
            setFlightDTOSet(airport, airportDTO);
            airportDTOList.add(airportDTO);
        }
        return airportDTOList;
    }

    public int updateAirportName(String currentName, String newName) {
        return airportDAO.updateAirportName(currentName,newName);
    }

    public int deleteAirportByName(String airportName) {
        return airportDAO.deleteAirportByName(airportName);
    }
}
