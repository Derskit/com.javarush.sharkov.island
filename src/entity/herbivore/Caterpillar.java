package entity.herbivore;

import config.Settings;
import entity.Plant;
import entity.island.Island;
import entity.predator.Predator;
import enums.HerbivoreType;
import enums.PredatorType;
import repository.Fabrics;
import util.MapLocation;

public class Caterpillar extends Herbivores {
    @Override
    public void eat() {
        for (int i = 0; i < Island.getLocations()[getX()][getY()].getQuantityEatables().get(Plant.PlantType.PLANT).size(); i++) {
            if (Island.getLocations()[getX()][getY()].getQuantityEatables().get(Plant.PlantType.PLANT).size() > 0) {
                if (Plant.PlantType.PLANT.equals(Island.getLocations()[getX()][getY()].getQuantityEatables().get(Plant.PlantType.PLANT).get(i).getType())) {
                    Island.getLocations()[getX()][getY()].getQuantityEatables().get(Plant.PlantType.PLANT).remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public void move() {
    }

    @Override
    public void reproduction() {
        if (Island.getLocations()[getX()][getY()].getQuantityEatables().get(getType()).size() < MapLocation.arrayToMap(Settings.maxEatables).get(getType())
                && Island.getLocations()[getX()][getY()].getQuantityEatables().get(getType()).size() > 1) {
            Island.getLocations()[getX()][getY()].isLock = true;
            Island.getLocations()[getX()][getY()].getQuantityEatables().get(getType()).add(Fabrics.getFabric().createHerbivores((HerbivoreType) getType()));
            Island.getLocations()[getX()][getY()].isLock = false;
        }
    }
}
