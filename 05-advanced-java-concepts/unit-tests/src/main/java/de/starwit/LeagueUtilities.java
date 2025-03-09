package de.starwit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeagueUtilities {

    public List<LocalDate> computeSeason(LocalDate startDate) {
        //TODO
        return null;
    }

    /**
     * Shall calculate all Fridays, Saturdays and Sundays for a season of n match
     * days.
     */
    public List<LocalDate> computeSeason(int matchdays) {
        List<LocalDate> result = new ArrayList<>();
        var nextFriday = getNextFriday();
        for (int j = 0; j < matchdays; j++) {
            result.add(nextFriday);
            result.add(nextFriday.plusDays(1));
            result.add(nextFriday.plusDays(2));
            nextFriday = nextFriday.plusDays(7);
        }

        return result;
    }

    private LocalDate getNextFriday() {
        LocalDate today = LocalDate.now();
        // Get days until next Friday
        int daysUntilFriday = DayOfWeek.FRIDAY.getValue() - today.getDayOfWeek().getValue();

        // If today is Friday or we've already passed Friday this week,
        // add 7 days to get next Friday
        if (daysUntilFriday <= 0) {
            daysUntilFriday += 7;
        }

        return today.plusDays(daysUntilFriday);
    }
}
