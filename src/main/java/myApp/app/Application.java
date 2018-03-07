package myApp.app;

import myApp.Reader.Reader;
import myApp.components.activities.Activity;
import myApp.components.hierarchy.City;
import myApp.components.hierarchy.Country;
import myApp.components.hierarchy.County;
import myApp.components.hierarchy.Location;
import myApp.services.city.CityService;
import myApp.services.country.CountryService;
import myApp.services.county.CountyService;
import myApp.services.location.ILocationService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication(scanBasePackages = "myApp")
@EnableJpaRepositories(basePackages = "myApp")
@EntityScan(basePackages = "myApp")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    ILocationService locationService;
    @Autowired
    CityService cityService;
    @Autowired
    CountyService countyService;
    @Autowired
    CountryService countryService;


    /**
     * Function that populates the database
     *
     * Reads entities from "input" file and updates or creates the corresponding
     * entities in the database maintaining the hierarchical structure of it.
     *
     * @param reader reader class used to parse the file with
     */
    public void createEntities(Reader reader) {
        String countryName = reader.nextString();
        Country country = countryService.findByName(countryName);
        if (country == null) {
            country = new Country(countryName, null);
            countryService.save(country);
        }

        String countyName = reader.nextString();
        County county = countyService.findByName(countyName);
        if (county == null) {
            county = new County(countyName, country);
            countyService.save(county);
        }

        String cityName = reader.nextString();
        City city = cityService.findByName(cityName);
        if (city == null) {
            city = new City(cityName, county);
            cityService.save(city);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String startDate = reader.nextString();
        String endDate = reader.nextString();

        Calendar calendarStartDate = Calendar.getInstance();
        try {
            calendarStartDate.setTime(formatter.parse(startDate));
        } catch (ParseException e) {
            System.out.println("Inserted wrong value for startDate");
            e.printStackTrace();
        }

        Calendar calendarEndDate = Calendar.getInstance();
        try {
            calendarEndDate.setTime(formatter.parse(endDate));
        } catch (ParseException e) {
            System.out.println("Inserted wrong value for startDate");
            e.printStackTrace();
        }

        Float averagePricePerDay = reader.nextFloat();
        String locationName = reader.nextString();

        Location location = new Location(locationName, city, averagePricePerDay, calendarStartDate, calendarEndDate);
        location.setSubEntities(null);

        int numberOfActivities = reader.nextInt();


        for (int i = 0; i < numberOfActivities; i++) {
            location.addActivity(new Activity(reader.nextString(), location));
        }

        locationService.save(location);
    }

    /**
     * Searches the database for the location with the indicated location name
     * and prints its details to console
     *
     * @param locationName name of the location to find
     */

    public void printLocationInfo(String locationName) {
        Location location = locationService.findByName(locationName);
        System.out.println(location);
    }


    /**
     * Searches the database for the first 5 locations from a County that can be
     * visited between startDate and endDate with the lowest averagePricePerDay.
     *
     * @param countyName name of the county the locations will be
     * @param startDate the date from which we would like to visit the location
     * @param endDate the date when we will leave the location
     */
    public void getTop5FromCounty(String countyName, Calendar startDate, Calendar endDate) {
        County county = countyService.findByName(countyName);
        List<City> cities = cityService.findAllByParentEntity(county);

        List<Location> locations = new ArrayList<>();
        for (City city : cities) {
            locations.addAll(locationService.findAllByParentEntity(city));
        }

        ListIterator<Location> iter = locations.listIterator();

        while (iter.hasNext()) {
            Location location = iter.next();
            LocalDate locStartDate = new LocalDate(location.getStartDate());
            LocalDate locEndDate = new LocalDate(location.getEndDate());

            LocalDate givenStartDate = new LocalDate(startDate);
            LocalDate givenEndDate = new LocalDate(endDate);
            if (locStartDate.isAfter(givenStartDate) || locEndDate.isBefore(givenEndDate)) {
                iter.remove();
            }
        }

        locations.sort(Comparator.comparingInt(o -> o.getAveragePricePerDay().intValue()));

        for(int i = 0; i < 5 && i < locations.size(); i++){
            System.out.print(locations.get(i).getName() + " ");
        }

        System.out.println();
    }

    @Override
    public void run(String... strings) throws Exception {

        Reader reader = new Reader("input");
        int numberOfEntities = reader.nextInt();
        for (int i = 0; i < numberOfEntities; i++) {
            createEntities(reader);
        }

        ///////////////////////////////Find info about location "locationName"/////////////////////////////////
        System.out.println("///////////////////////////////Find info about location locationName/////////////////////////////////");
        System.out.println("Find more about location \"Rarau'\"");
        printLocationInfo("Rarau");



        ///////////////////////////////Find Best Five from County/////////////////////////////////
        System.out.println("\n\n");
        System.out.println("///////////////////////////////Find Best Five from County/////////////////////////////////");
        System.out.println("Get best locations from county Suceava, with startDate < 19/07/2011 && endDate > 15/07/2012");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(formatter.parse("19/07/2011"));

        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(formatter.parse("15/07/2012"));

        getTop5FromCounty("Suceava", calendarStartDate, calendarEndDate);



        ///////////////////////////////Find Best Location by avarage price per day/////////////////////////////////
        System.out.println("\n\n");
        System.out.println("///////////////////////////////Find Best Location by avarage price per day/////////////////////////////////");
        System.out.println(locationService.findMinimumAvaragePerDay());



    }
}
