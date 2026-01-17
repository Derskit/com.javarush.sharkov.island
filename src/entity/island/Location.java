package entity.island;

import entity.Eatable;
import entity.Plant;
import util.MapLocation;
import repository.Fabrics;
import config.Settings;

import java.util.ArrayList;
import java.util.Map;

public class Location {
    public boolean isLock = false;

    private ArrayList<Eatable> eatables = new ArrayList<>();

    public ArrayList<Eatable> getEatables() {
        return eatables;
    }

    private Map<Enum, Integer> quantityEatables = Settings.createEatables();

    public Map<Enum, Integer> getQuantityEatables() {
        return quantityEatables;
    }

    public void plantGrowth() {
        if (quantityEatables.get(Plant.PlantType.PLANT) < MapLocation.arrayToMap(Settings.maxEatables).get(Plant.PlantType.PLANT)){
            Plant plant = Fabrics.getFabric().createPlant();
            eatables.add(plant);
            MapLocation.addInMap(plant.getType(), quantityEatables);
        }
    }
}
