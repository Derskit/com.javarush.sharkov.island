package entity.island;

import entity.Eatable;
import entity.Plant;
import util.MapLocation;
import repository.Fabrics;
import config.Settings;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    public boolean isLock = false;

    private Map<Enum, CopyOnWriteArrayList<Eatable>> quantityEatables = Settings.createEatables();

    public Map<Enum, CopyOnWriteArrayList<Eatable>> getQuantityEatables() {
        return quantityEatables;
    }

    public void plantGrowth() {
        if (quantityEatables.get(Plant.PlantType.PLANT).size() < MapLocation.arrayToMap(Settings.maxEatables).get(Plant.PlantType.PLANT)){
            quantityEatables.get(Plant.PlantType.PLANT).add(Fabrics.getFabric().createPlant());
        }
    }
}
