package excercise11;

import java.util.List;
import java.util.Objects;

public class CarDealership {
    private String name;
    private List<Car> inventory;

    public CarDealership(final String name, final List<Car> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getInventory() {
        return inventory;
    }

    public void setInventory(List<Car> inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDealership that = (CarDealership) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventory);
    }

    @Override
    public String toString() {
        return "CarDealership{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}

