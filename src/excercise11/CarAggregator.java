package excercise11;

import java.util.*;
import java.util.stream.Collectors;

public class CarAggregator {

    private static final List<Car> CARS = Arrays.asList(
            new Car("VW", "Polo", "Red", 20000.0),
            new Car("Porsche", "911", "Silver", 200000.0),
            new Car("Mercedes", "C-Class", "Black", 75000.0),
            new Car("BMW", "M6", "Silver", 125000.0),
            new Car("Seat", "Leon", "Blue", 25000.0),
            new Car("VW", "T6", "Silver", 75000.0),
            new Car("Tesla", "Model S", "Rainbow", 125000.0),
            new Car("Toyota", "Prius", "White", 50000.0)
    );

    public static void main(final String[] args) {
        final CarAggregator ca = new CarAggregator();

        System.out.println("only VW (for-loop)");
        System.out.println(ca.getOnlyVW(CARS));
        System.out.println("only VW (stream)");
        System.out.println(ca.getOnlyVWStream(CARS));

        System.out.println("----------------------");

        System.out.println("all models (for-loop)");
        System.out.println(ca.getAllModels(CARS));
        System.out.println("all models (stream)");
        System.out.println(ca.getAllModelsStream(CARS));

        System.out.println("----------------------");

        System.out.println("rainbow colored car (for-loop");
        System.out.println(ca.getCarWithColor(CARS, "Rainbow"));
        System.out.println("rainbow colored car (stream)");
        System.out.println(ca.getCarWithColorStream(CARS, "Rainbow"));

        System.out.println("elephant colored car??? (for-loop");
        System.out.println(ca.getCarWithColor(CARS, "Elephant"));
        System.out.println("elephant colored car??? (stream)");
        System.out.println(ca.getCarWithColorStream(CARS, "Elephant"));


        System.out.println("----------------------");

        System.out.println("get all colors (for-loop)");
        System.out.println(ca.getAllColors(CARS));
        System.out.println("get all colors (stream)");
        System.out.println(ca.getAllColorsStream(CARS));
    }

    /**
     * Return all cars manufactured by VW.
     *
     * @param cars list of cars
     * @return vw cars
     */
    private List<Car> getOnlyVW(final List<Car> cars) {
        final List<Car> vwCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals("VW")) {
                vwCars.add(car);
            }
        }
        return vwCars;
    }

    /**
     * Return all cars manufactured by VW.
     *
     * @param cars list of cars
     * @return vw cars
     */
    private List<Car> getOnlyVWStream(final List<Car> cars) {
        cars.stream()
                .filter(car -> car
                        .getBrand()
                        .equals("VW"));
        return Collections.emptyList();
    }


    /**
     * Return all different car model names.
     *
     * @param cars list of cars
     * @return car models
     */
    private List<String> getAllModels(final List<Car> cars) {
        final List<String> models = new ArrayList<>();
        for (Car car : cars) {
            models.add(car.getModel());
        }
        return models;
    }

    /**
     * Return all different car model names.
     *
     * @param cars list of cars
     * @return car models
     */
    private List<String> getAllModelsStream(final List<Car> cars) {
        List<String> stringList = cars.stream()
                .map(e ->
                {
                    String modle = (String) e.getModel();
                    return modle;
                })
                .collect(Collectors.toList());
        return stringList;
    }


    /**
     * Return any car with the providec color.
     * If no car with this color exists, return an empty Optional.
     *
     * @param cars list of cars
     * @param color color of car
     * @return car with wanted color
     */
    private Optional<Car> getCarWithColor(final List<Car> cars, final String color) {
        Optional<Car> result = Optional.empty();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase(color)) {
                result = Optional.of(car);
            }
        }
        return result;
    }

    /**
     * Return any car with the providec color.
     * If no car with this color exists, return an empty Optional.
     *
     * @param cars list of cars
     * @param color color of car
     * @return car with wanted color
     */
    private Optional<Car> getCarWithColorStream(final List<Car> cars, final String color) {
        Optional<Car> result = cars.stream()
                                .filter(o -> o.getColor().equalsIgnoreCase(color))
                                .findFirst();
        return result;
    }

    /**
     * Return a List of all colors that exist in the given list of cars.
     * Duplicates are eliminated.
     *
     * @param cars list of cars
     * @return list of colors without duplicates
     */
    private List<String> getAllColors(final List<Car> cars) {
        final List<String> colors = new ArrayList<>();
        for (Car car : cars) {
            final String color = car.getColor();
            if (!colors.contains(color)) {
                colors.add(color);
            }
        }
        return colors;
    }

    /**
     * Return a List of all colors that exist in the given list of cars.
     * Duplicates are eliminated.
     *
     * @param cars list of cars
     * @return list of colors without duplicates
     */
    private List<String> getAllColorsStream(final List<Car> cars) {
        List<String> colorList = cars.stream()
                .map(e -> e.getColor())
                .distinct()
                .collect(Collectors.toList());

        return colorList;
    }
}
