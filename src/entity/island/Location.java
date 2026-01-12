package entity.island;

import entity.Eatable;
import util.Settings;

import java.util.ArrayList;
import java.util.Map;

public class Location {

    public static ArrayList eatables = new ArrayList<>();

    public Map<Enum, Integer> quantityEatables = Settings.createEatables();
    public Location(){

    }
}
