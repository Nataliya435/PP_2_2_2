package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private static int ID_CAR;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++ID_CAR, "Car1", "blue"));
        cars.add(new Car(++ID_CAR, "Car2", "red"));
        cars.add(new Car(++ID_CAR, "Car3", "black"));
        cars.add(new Car(++ID_CAR, "Car4", "red"));
        cars.add(new Car(++ID_CAR, "Car5", "black"));
    }

    @Override
    public List<Car> printCars(int count) {
        if (count < 1 || count > 5) {
            count = cars.size();
        }
        return cars.stream().limit(count).toList();
    }
}
