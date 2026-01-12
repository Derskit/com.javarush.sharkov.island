package util;

import entity.Animal;
import entity.Eatable;
import entity.Plant;
import entity.herbivore.Buffalo;
import entity.herbivore.HerbivoreType;
import entity.predator.PredatorType;

import java.util.HashMap;
import java.util.Map;

import static entity.Plant.PlantType.PLANT;

public class Settings {
    public static int x = 1;
    public static int y = 1;

    public static int minHerbivore = 10;
    public static int minPredator = 5;

    static Object[][] mapMaxEatables = {{PredatorType.WOLF,30},
            {PredatorType.BOA_CONSTRICTOR, 30},
            {PredatorType.FOX, 30},
            {PredatorType.BEAR, 5},
            {PredatorType.EAGLE, 20},
            {HerbivoreType.HORSE, 20},
            {HerbivoreType.DEER, 20},
            {HerbivoreType.RABBIT, 150},
            {HerbivoreType.MOUSE, 500},
            {HerbivoreType.GOAT, 140},
            {HerbivoreType.SHEEP, 140},
            {HerbivoreType.WILD_BOAR, 50},
            {HerbivoreType.BUFFALO, 10},
            {HerbivoreType.DUCK, 200},
            {HerbivoreType.CATERPILLAR, 100},
            {PLANT, 200}};
    public static Map<Enum, Integer> maxEatables(){
        Map<Enum, Integer> map = new HashMap<>();
        for (Object[] row : mapMaxEatables){
            map.put((Enum) row[0], (Integer) row[1]);
        }
        return map;
    }
    public static Map<Enum, Integer> createEatables(){
        Map<Enum, Integer> map = new HashMap<>();
        for (Object[] row : mapMaxEatables){
            map.put((Enum) row[0], 0);
        }
        return map;
    }

}
