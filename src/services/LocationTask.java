package services;

import entity.Animal;
import entity.Eatable;
import entity.Plant;
import entity.island.Island;
import entity.island.Location;

public class LocationTask implements Runnable {

    private Integer x;
    private Integer y;
    private Location location;

    public LocationTask(Integer xLocation, Integer yLocation) {
        x = xLocation;
        y = yLocation;
        location = Island.getLocations()[x][y];
    }

    @Override
    public void run() {
        if (true) {
            for (Eatable eatable : location.getEatables()) {
                if (!eatable.getType().equals(Plant.PlantType.PLANT)) {
                    Animal animal = (Animal) eatable;
                    animal.move();
                    animal.reproduction();
                    animal.eat();
                }
            }
        }
    }
}
