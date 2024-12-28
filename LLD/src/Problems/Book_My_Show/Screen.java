package Problems.Book_My_Show;

import Problems.Book_My_Show.ENUMS.ScreenType;

import java.util.List;

public class Screen {
    ScreenType screenType;
    int totalSeats;
    List<Show> showList;

    public Screen(ScreenType screenType, int totalSeats, List<Show> showList) {
        this.screenType = screenType;
        this.totalSeats = totalSeats;
        this.showList = showList;
    }
}
