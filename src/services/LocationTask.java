package services;

import entity.Animal;
import entity.Eatable;
import entity.Plant;
import entity.island.Island;
import entity.island.Location;

import java.util.concurrent.CopyOnWriteArrayList;

public class LocationTask implements Runnable {

    private Integer x;
    private Integer y;
    private Location location;

    public LocationTask(Integer xLocation, Integer yLocation ) {
        x = xLocation;
        y = yLocation;
        location = Island.getLocations()[x][y];
    }

    @Override
    public void run() {
        if (!location.isLock) {
            CopyOnWriteArrayList<Enum> list = new CopyOnWriteArrayList<>();
            for (Enum key : location.getQuantityEatables().keySet()) {
                if (!key.equals(Plant.PlantType.PLANT)){
                    for (Eatable eatable : location.getQuantityEatables().get(key)) {
                        Animal animal = (Animal) eatable;
                        animal.move();
                        animal.reproduction();
                        animal.eat();
                        //System.out.println("WORK");
                    }
                }
            }


        }

    }
}
