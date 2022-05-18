import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println(findPlanesLeavingInTheNextTwoHours(Airport.getInstance()));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date now = new Date();


        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(flights -> flights.stream().distinct())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> flight.getDate().getHours() >= now.getHours() && flight.getDate().getHours() <= now.getHours() + 2)
                .collect(Collectors.toList());
    }
}