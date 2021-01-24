package business.service;

import business.dto.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;


@Service
public class TripService {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    AirportDAO airportDAO;
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insert(TripDTO tripDTO) {
        Trip trip = getTrip(tripDTO);
        tripDAO.insert(trip);
    }

    public Trip getTrip(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setName(tripDTO.getName());
        setAirport(tripDTO, trip);
        setHotel(tripDTO, trip);
        trip.setDepartureDate(tripDTO.getDepartureDate());
        trip.setReturnDate(tripDTO.getReturnDate());
        trip.setNumberDays(tripDTO.getNumberDays());
        trip.setMealType(tripDTO.getMealType());
        trip.setAdultPrice(tripDTO.getAdultPrice());
        trip.setKidPrice(tripDTO.getKidPrice());
        trip.setPromoted(tripDTO.isPromoted());
        trip.setStock(tripDTO.getStock());
        return trip;
    }

    //aici setam aeroportul
    public void setAirport(TripDTO tripDTO, Trip trip) {
        Airport airportFound = airportDAO.findAirportByName(tripDTO.getAirportDTO().getName());
        if (airportFound != null) {
            trip.setAirport(airportFound);
        }
        Airport airport = new Airport();
        airport.setName(tripDTO.getAirportDTO().getName());
        setCity(tripDTO, airport);
        setFlightSet(tripDTO, airport);
        trip.setAirport(airport);
    }

    public void setCity(TripDTO tripDTO, Airport airport) {
        City cityFound = cityDAO.findCityByName(tripDTO.getAirportDTO().getCityDTO().getName());
        if (cityFound != null) {
            airport.setCity(cityFound);
        }
        City city = new City();
        city.setName(tripDTO.getAirportDTO().getCityDTO().getName());
        setCountry(tripDTO, city);
        airport.setCity(city);
    }

    public void setCountry(TripDTO tripDTO, City city) {
        Country countryFound = countryDAO.findCountryByName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
        if (countryFound != null) {
            city.setCountry(countryFound);
        }
        Country country = new Country();
        country.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
        setContinent(tripDTO, country);
        city.setCountry(country);
    }

    public void setContinent(TripDTO tripDTO, Country country) {
        Continent continentFound = continentDAO.findContinentByName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (continentFound != null) {
            country.setContinent(continentFound);
        }
        Continent continent = new Continent();
        continent.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        country.setContinent(continent);
    }

    public void setFlightSet(TripDTO tripDTO, Airport airport) {
        Set<Flight> flightSet = new HashSet<>();
        for (FlightDTO flightDTO : tripDTO.getAirportDTO().getFlightDTOSet()) {
            Flight flight = new Flight();
            flight.setFlightDepartureDate(flightDTO.getFlightDepartureDate());
            flight.setFlightDepartureTime(flightDTO.getFlightDepartureTime());
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

    //aici setam hotelul
    public void setHotel(TripDTO tripDTO, Trip trip) {
        Hotel hotelFound = hotelDAO.findHotelByNameAndByCityName(tripDTO.getHotelDTO().getName(), tripDTO.getHotelDTO().getCityDTO().getName());
        if (hotelFound != null) {
            trip.setHotel(hotelFound);
        }
        Hotel hotel = new Hotel();
        hotel.setName(tripDTO.getHotelDTO().getName());
        hotel.setStars(tripDTO.getHotelDTO().getStars());
        hotel.setDescription(tripDTO.getHotelDTO().getDescription());
        setCityForHotel(tripDTO, hotel);
        setRoomSet(tripDTO, hotel);
        trip.setHotel(hotel);
    }

    public void setCityForHotel(TripDTO tripDTO, Hotel hotel) {
        City cityFound = cityDAO.findCityByName(tripDTO.getHotelDTO().getCityDTO().getName());
        if (cityFound != null) {
            hotel.setCity(cityFound);
        }
        City city = new City();
        city.setName(tripDTO.getHotelDTO().getCityDTO().getName());
        setCountryForHotel(tripDTO, city);
        hotel.setCity(city);
    }

    public void setCountryForHotel(TripDTO tripDTO, City city) {
        Country countryFound = countryDAO.findCountryByName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getName());
        if (countryFound != null) {
            city.setCountry(countryFound);
        }
        Country country = new Country();
        country.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getName());
        setContinentForHotel(tripDTO, country);
        city.setCountry(country);
    }

    public void setContinentForHotel(TripDTO tripDTO, Country country) {
        Continent continentFound = continentDAO.findContinentByName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (continentFound != null) {
            country.setContinent(continentFound);
        }
        Continent continent = new Continent();
        continent.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        country.setContinent(continent);
    }

    public void setRoomSet(TripDTO tripDTO, Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for (RoomDTO roomDTO : tripDTO.getHotelDTO().getRoomDTOSet()) {
            Room room = new Room();
            room.setRoomType(roomDTO.getRoomType());
            room.setExtraBed(roomDTO.isExtraBed());
            room.setAvailableRooms(roomDTO.getAvailableRooms());
            room.setHotel(hotel);
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }

    public long countTripByName(String name) {
        return tripDAO.countTripByName(name);
    }

    //aici convertesc Trip-ul in TripDTO
    public TripDTO getTripDTO(Trip trip) {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setName(trip.getName());
        setAirportDTO(trip, tripDTO);
        setHotelDTO(trip, tripDTO);
        tripDTO.setDepartureDate(trip.getDepartureDate());
        tripDTO.setReturnDate(trip.getReturnDate());
        tripDTO.setNumberDays(trip.getNumberDays());
        tripDTO.setMealType(trip.getMealType());
        tripDTO.setAdultPrice(trip.getAdultPrice());
        tripDTO.setKidPrice(trip.getKidPrice());
        tripDTO.setPromoted(trip.isPromoted());
        tripDTO.setStock(trip.getStock());
        return tripDTO;
    }

    public void setAirportDTO(Trip trip, TripDTO tripDTO) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(trip.getAirport().getName());
        setCityDTO(trip, airportDTO);
        setFlightDTOSet(trip, airportDTO);
        tripDTO.setAirportDTO(airportDTO);
    }

    public void setCityDTO(Trip trip, AirportDTO airportDTO) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(trip.getAirport().getCity().getName());
        setCountryDTO(trip, cityDTO);
        airportDTO.setCityDTO(cityDTO);
    }

    public void setCountryDTO(Trip trip, CityDTO cityDTO) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(trip.getAirport().getCity().getCountry().getName());
        setContinentDTO(trip, countryDTO);
        cityDTO.setCountryDTO(countryDTO);
    }

    public void setContinentDTO(Trip trip, CountryDTO countryDTO) {
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(trip.getAirport().getCity().getCountry().getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
    }

    public void setFlightDTOSet(Trip trip, AirportDTO airportDTO) {
        Set<FlightDTO> flightDTOSet = new HashSet<>();
        for (Flight flight : trip.getAirport().getFlightSet()) {
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

    public void setHotelDTO(Trip trip, TripDTO tripDTO) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(trip.getHotel().getName());
        hotelDTO.setStars(trip.getHotel().getStars());
        hotelDTO.setDescription(trip.getHotel().getDescription());
        setCityDTOForHotelDTO(trip, hotelDTO);
        setRoomDTOSet(trip, hotelDTO);
        tripDTO.setHotelDTO(hotelDTO);
    }

    public void setCityDTOForHotelDTO(Trip trip, HotelDTO hotelDTO) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(trip.getHotel().getCity().getName());
        setCountryDTOForHotelDTO(trip, cityDTO);
        hotelDTO.setCityDTO(cityDTO);
    }

    public void setCountryDTOForHotelDTO(Trip trip, CityDTO cityDTO) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(trip.getHotel().getCity().getCountry().getName());
        setContinentDTOForHotelDTO(trip, countryDTO);
        cityDTO.setCountryDTO(countryDTO);
    }

    public void setContinentDTOForHotelDTO(Trip trip, CountryDTO countryDTO) {
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(trip.getHotel().getCity().getCountry().getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
    }

    public void setRoomDTOSet(Trip trip, HotelDTO hotelDTO) {
        Set<RoomDTO> roomDTOSet = new HashSet<>();
        for (Room room : trip.getHotel().getRoomSet()) {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomType(room.getRoomType());
            roomDTO.setExtraBed(room.isExtraBed());
            roomDTO.setAvailableRooms(room.getAvailableRooms());
            roomDTOSet.add(roomDTO);
        }
        hotelDTO.setRoomDTOSet(roomDTOSet);
    }

    public TripDTO findTripByName(String tripName) {
        Trip tripFound = tripDAO.findByName(tripName);
        if (tripFound == null) {
            return null;
        }
        return getTripDTO(tripFound);
    }

    public List<TripDTO> findAllTrips() {
        List<Trip> tripList = tripDAO.findAllTrips();
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByContinentName(String continentName) {
        List<Trip> tripList = tripDAO.findTripsByContinentName(continentName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByCountryName(String countryName) {
        List<Trip> tripList = tripDAO.findTripsByCountryName(countryName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByCityOfStay(String cityName) {
        List<Trip> tripList = tripDAO.findByCityOfStay(cityName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findByHotelOfStay(String hotelName) {
        List<Trip> tripList = tripDAO.findByHotelOfStay(hotelName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByCityOfDeparture(String cityDepartureName) {
        List<Trip> tripList = tripDAO.findTripsByCityOfDeparture(cityDepartureName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByAirport(String airportName) {
        List<Trip> tripList = tripDAO.findTripsByAirport(airportName);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByDepartureDate(Date departureDate) {
        List<Trip> tripList = tripDAO.findTripsByDepartureDate(departureDate);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByReturnDate(Date returnDate) {
        List<Trip> tripList = tripDAO.findTripsByReturnDate(returnDate);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByMealType(String mealType) {
        List<Trip> tripList = tripDAO.findTripsByMealType(mealType);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByStandardOfHotel(int hotelStars) {
        List<Trip> tripList = tripDAO.findTripsByStandardOfHotel(hotelStars);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByNumberOfDays(int numberDays) {
        List<Trip> tripList = tripDAO.findTripsByNumberOfDays(numberDays);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByPromoted(boolean promoted) {
        List<Trip> tripList = tripDAO.findTripsByPromoted(promoted);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsByMaximPrice(double maxPriceForAdult, double maxPriceForKid) {
        List<Trip> tripList = tripDAO.findTripsByMaximPriceForAdult(maxPriceForAdult, maxPriceForKid);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findRecentlyPurchasedTrips(Date referenceDate) {
        List<Trip> tripList = tripDAO.findRecentlyPurchasedTrips(referenceDate);
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = getTripDTO(trip);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public void updateTripStock(int stock) {
        tripDAO.updateTripStock(stock);
    }

    public int updateAdultPriceAndKidPriceByTripName(double adultPrice, double kidPrice, String tripName) {
        return tripDAO.updateAdultPriceAndKidPriceByTripName(adultPrice, kidPrice, tripName);
    }

    public int deleteTripByName(String tripName) {
        return tripDAO.deleteTripByName(tripName);
    }

    public boolean checkTripAvailability(TripDTO tripDTO) {
        return tripDTO.getStock() > 0;
    }
}
