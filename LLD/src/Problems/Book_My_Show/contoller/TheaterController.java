package Problems.Book_My_Show.contoller;

import Problems.Book_My_Show.Theater;

import java.util.*;

public class TheaterController {
    private final DataManager dataManager;

    public TheaterController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<Theater> getTheatersByCity(String city) {
        return dataManager.getTheatersByCity(city);
    }

    public void addTheater(String city, Theater theater) {
        dataManager.addTheater(city, theater);
    }
}
