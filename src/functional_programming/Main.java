import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*
         * Classic way
         */
        var cities = new ArrayList<String>();
        cities.add("Tinghir");
        cities.add("Ichem");
        cities.add("Tazroute");
        cities.add("Tisghit");

        var citiesCap = new ArrayList<>();

        for (var city : cities) {
            citiesCap.add(city.toUpperCase());
        }

        System.out.println(citiesCap);

        /*
         * API Stream
         */

        var citiesCapFunctionnalStreal = cities.stream()
                .map(city -> city.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(citiesCapFunctionnalStreal);
    }
}
