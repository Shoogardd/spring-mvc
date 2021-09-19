package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CarDaoImpl implements CarDao{

    private static  List <Car> cars = new ArrayList<>();{
        cars.add(new Car("BMW", "m5", 2015));
        cars.add(new Car("Toyota", "Sequoia", 2010));
        cars.add(new Car("Subaru", "Forester", 2013));
        cars.add(new Car("Audi", "100", 1990));
        cars.add(new Car("Mitsubishi", "Pajero", 2020));
    }

    @Override
    public List<Car> getCars() {
        List <Car> cars1 = new ArrayList<>(cars);
        return cars1;
    }

    @Override
    public List<Car> getCount(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
