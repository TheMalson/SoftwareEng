package excercise11;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedCarAggregator {
    private static final List<CarDealership> CAR_DEALERS = Arrays.asList(
            new CarDealership("VW-Group Autohaus: Hans Wurst", Arrays.asList(
                    new Car("VW", "Polo", "Red", 20000.0),
                    new Car("Porsche", "911", "Silver", 200000.0),
                    new Car("Seat", "Leon", "Blue", 25000.0),
                    new Car("VW", "T6", "Silver", 75000.0)
            )),
            new CarDealership("Joe's Cheap Backyard Cars", Arrays.asList(
                    new Car("VW", "Polo", "Rust-Red", 1500.0),
                    new Car("Seat", "Leon", "Spotty", 2333.0),
                    new Car("VW", "T6", "Greyish", 80000.0),
                    new Car("Toyota", "Prius", "Dirty-White", 3500)
            )),
            new CarDealership("Supercars Discount Market", Arrays.asList(
                    new Car("Porsche", "911", "Silver", 300000.0),
                    new Car("Mercedes", "C-Class", "Black", 175000.0),
                    new Car("BMW", "M6", "Silver", 225000.0),
                    new Car("Tesla", "Model S", "Rainbow", 225000.0)
            ))
    );

    public static void main(final String[] args) {
        final AdvancedCarAggregator ca = new AdvancedCarAggregator();

        System.out.println("All cars from all dealers");
        System.out.println(ca.getAllCars(CAR_DEALERS));

        System.out.println("----------------------");

        System.out.println("Cheapest Polo");
        System.out.println(ca.getCheapestCarByModel(CAR_DEALERS, "Polo"));
    }

    /**
     * Returns a List of all cars from a list of car dealerships.
     *
     * For the implementation: use flatMap() method ({@link java.util.stream.Stream#flatMap(Function)}).
     *
     * @param carDealers car dealerships
     * @return list of all cars.
     */
    private List<Car> getAllCars(final List<CarDealership> carDealers) {
        List<Car> allCarList = carDealers.stream()
                .map(e -> e.getInventory())
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        return allCarList;
    }


    /**
     * OPTIONAL!
     * Advanced Exercise:
     *
     * Returns the cheapest car with a provided model from any carDealership.
     *
     * @param carDealers car dealerships
     * @param model model of the car
     * @return the cheapest car with the provided model or if none exists
     */
    private Optional<Car> getCheapestCarByModel(final List<CarDealership> carDealers, final String model) {
        List<Car> allCarList = carDealers.stream()
                .map(e -> e.getInventory())
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());

        Optional<Car> cheapestCar = allCarList.stream()
                .filter(o -> o.getModel().equalsIgnoreCase(model))
                .min(Comparator.comparing(Car:: getPrice));
        return cheapestCar;
    }
}
