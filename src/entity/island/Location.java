package entity.island;

import entity.Eatable;
import entity.Plant;
import util.AddInMap;
import repository.Fabrics;
import config.Settings;

import java.util.ArrayList;
import java.util.Map;

public class Location{

    public ArrayList<Eatable> eatables = new ArrayList<>();

    public ArrayList<Eatable> getEatables() {
        return eatables;
    }

    public Map<Enum, Integer> quantityEatables = Settings.createEatables();

    public Map<Enum, Integer> getQuantityEatables() {
        return quantityEatables;
    }

    public void plantGrowth(){
        Plant plant = Fabrics.getFabric().createPlant();
        eatables.add(plant);
        AddInMap.addInMap(plant, quantityEatables);
    }
}
