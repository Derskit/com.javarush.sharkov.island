package config;

import entity.Eatable;
import enums.HerbivoreType;
import enums.PredatorType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static entity.Plant.PlantType.PLANT;

public class Settings {
    public static int xMapIsland = 2;
    public static int yMapIsland = 2;

    public static int minHerbivore = 20;
    public static int minPredator = 10;

    public static Object[][] maxDaysWithoutFood =
            {{PredatorType.WOLF, 8},
            {PredatorType.BOA_CONSTRICTOR, 10},
            {PredatorType.FOX, 5},
            {PredatorType.BEAR, 6},
            {PredatorType.EAGLE, 4},
            {HerbivoreType.HORSE, 7},
            {HerbivoreType.DEER, 5},
            {HerbivoreType.RABBIT, 4},
            {HerbivoreType.MOUSE, 5},
            {HerbivoreType.GOAT, 6},
            {HerbivoreType.SHEEP, 7},
            {HerbivoreType.WILD_BOAR, 5},
            {HerbivoreType.BUFFALO, 9},
            {HerbivoreType.DUCK, 3}};

    public static Object[][] maxEatables =
            {{PredatorType.WOLF,30},
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

    public static Object[][] probabilitiesOfEating =
            {{PredatorType.WOLF, new Object[][]{
                    {HerbivoreType.HORSE, 10}, {HerbivoreType.DEER, 15},
                    {HerbivoreType.RABBIT, 60}, {HerbivoreType.MOUSE, 80},
                    {HerbivoreType.GOAT, 60}, {HerbivoreType.SHEEP, 70},
                    {HerbivoreType.WILD_BOAR, 15}, {HerbivoreType.DUCK, 40}}},
            {PredatorType.BOA_CONSTRICTOR, new Object[][]{
                    {PredatorType.FOX, 15}, {HerbivoreType.RABBIT, 20},
                    {HerbivoreType.MOUSE, 40}, {HerbivoreType.DUCK, 10}}},
            {PredatorType.FOX, new Object[][]{
                    {HerbivoreType.RABBIT, 70}, {HerbivoreType.MOUSE, 90},
                    {HerbivoreType.DUCK, 60}, {HerbivoreType.CATERPILLAR, 40}}},
            {PredatorType.BEAR, new Object[][]{
                    {PredatorType.BOA_CONSTRICTOR, 80}, {HerbivoreType.HORSE, 40},
                    {HerbivoreType.DEER, 80}, {HerbivoreType.RABBIT, 80},
                    {HerbivoreType.MOUSE, 90}, {HerbivoreType.GOAT, 70},
                    {HerbivoreType.SHEEP, 70}, {HerbivoreType.WILD_BOAR, 50},
                    {HerbivoreType.BUFFALO, 20}, {HerbivoreType.DUCK, 10}}},
            {PredatorType.EAGLE, new Object[][]{
                    {PredatorType.FOX, 10}, {HerbivoreType.RABBIT, 90},
                    {HerbivoreType.MOUSE, 90}, {HerbivoreType.DUCK, 80}}},
            {HerbivoreType.HORSE, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.DEER, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.RABBIT, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.MOUSE, new Object[][]{
                    {PLANT, 100}, {HerbivoreType.CATERPILLAR, 90}}},
            {HerbivoreType.GOAT, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.SHEEP, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.WILD_BOAR, new Object[][]{
                    {PLANT, 100}, {HerbivoreType.CATERPILLAR, 90},
                    {HerbivoreType.MOUSE, 90}}},
            {HerbivoreType.BUFFALO, new Object[][]{
                    {PLANT, 100}}},
            {HerbivoreType.DUCK, new Object[][]{
                    {PLANT, 100}, {HerbivoreType.CATERPILLAR, 90}}},
            {HerbivoreType.CATERPILLAR, new Object[][]{
                    {PLANT, 100}}}};

    public static Object[][] speeds = {{PredatorType.WOLF,3},
            {PredatorType.BOA_CONSTRICTOR, 1},
            {PredatorType.FOX, 2},
            {PredatorType.BEAR, 2},
            {PredatorType.EAGLE, 3},
            {HerbivoreType.HORSE, 4},
            {HerbivoreType.DEER, 4},
            {HerbivoreType.RABBIT, 2},
            {HerbivoreType.MOUSE, 1},
            {HerbivoreType.GOAT, 3},
            {HerbivoreType.SHEEP, 3},
            {HerbivoreType.WILD_BOAR, 2},
            {HerbivoreType.BUFFALO, 3},
            {HerbivoreType.DUCK, 4}};

    public static Object[][] weights = {{PredatorType.WOLF,50f},
            {PredatorType.BOA_CONSTRICTOR, 15f},
            {PredatorType.FOX, 8f},
            {PredatorType.BEAR, 500f},
            {PredatorType.EAGLE, 6f},
            {HerbivoreType.HORSE, 400f},
            {HerbivoreType.DEER, 300f},
            {HerbivoreType.RABBIT, 2f},
            {HerbivoreType.MOUSE, 0.05f},
            {HerbivoreType.GOAT, 60f},
            {HerbivoreType.SHEEP, 70f},
            {HerbivoreType.WILD_BOAR, 400f},
            {HerbivoreType.BUFFALO, 700f},
            {HerbivoreType.DUCK, 1f},
            {HerbivoreType.CATERPILLAR, 0.01f},
            {PLANT, 1f}};

    public static Object[][] foodWeight = {{PredatorType.WOLF,8f},
            {PredatorType.BOA_CONSTRICTOR, 3f},
            {PredatorType.FOX, 2f},
            {PredatorType.BEAR, 80f},
            {PredatorType.EAGLE, 1f},
            {HerbivoreType.HORSE, 60f},
            {HerbivoreType.DEER, 50f},
            {HerbivoreType.RABBIT, 0.45f},
            {HerbivoreType.MOUSE, 0.01f},
            {HerbivoreType.GOAT, 10f},
            {HerbivoreType.SHEEP, 15f},
            {HerbivoreType.WILD_BOAR, 50f},
            {HerbivoreType.BUFFALO, 100f},
            {HerbivoreType.DUCK, 0.15f}};

    public static Map<Enum, CopyOnWriteArrayList<Eatable>> createEatables(){
        Map<Enum, CopyOnWriteArrayList<Eatable>> map = new ConcurrentHashMap<>();
        for (Object[] row : maxEatables){
            map.put((Enum) row[0],new CopyOnWriteArrayList<Eatable>());
        }
        return map;
    }
    public static Map<Enum, Integer> createEatablesStatistic(){
        Map<Enum, Integer> map = new HashMap<>();
        for (Object[] row : maxEatables){
            map.put((Enum) row[0], 0);
        }
        return map;
    }
}
