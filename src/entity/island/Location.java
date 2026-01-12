package entity.island;

import entity.Eatable;
import entity.Plant;
import util.AddInMap;
import util.Fabrics;
import util.Settings;

import java.util.ArrayList;
import java.util.Map;

public class Location {

    public static ArrayList eatables = new ArrayList<>();

    public ArrayList getEatables() {
        return eatables;
    }

    public static Map<Enum, Integer> quantityEatables = Settings.createEatables();

    public Map<Enum, Integer> getQuantityEatables() {
        return quantityEatables;
    }

    public static void plantGrowth(){
        Plant plant = Fabrics.getFabric().createPlant();
        eatables.add(plant);
        AddInMap.addInMap(plant, quantityEatables);
    }
}
