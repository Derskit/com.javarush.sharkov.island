package repository;

import config.Settings;
import entity.Animal;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;
import enums.HerbivoreType;
import enums.PredatorType;
import util.ArraySearch;
import util.ArraySort;

public final class Fabrics {
    private static final Fabrics fabric = new Fabrics();

    public static Fabrics getFabric() {
        return fabric;
    }

    public Plant createPlant() {
        return new Plant();
    }

    public Predator createPredator(PredatorType type) {
        Predator predator = null;

        switch (type) {
            case FOX -> predator = new Fox();
            case BEAR -> predator = new Bear();
            case WOLF -> predator = new Wolf();
            case EAGLE -> predator = new Eagle();
            case BOA_CONSTRICTOR -> predator = new BoaConstrictor();
        }
        return (Predator) setParameters(predator, type);
    }

    public Herbivores createHerbivores(HerbivoreType type) {
        Herbivores herbivores = null;

        switch (type) {
            case DEER -> herbivores = new Deer();
            case DUCK -> herbivores = new Duck();
            case GOAT -> herbivores = new Goat();
            case HORSE -> herbivores = new Horse();
            case RABBIT -> herbivores = new Rabbit();
            case MOUSE -> herbivores = new Mouse();
            case SHEEP -> herbivores = new Sheep();
            case WILD_BOAR -> herbivores = new WildBoar();
            case BUFFALO -> herbivores = new Buffalo();
            case CATERPILLAR -> herbivores = new Caterpillar();
        }
        return (Herbivores) setParameters(herbivores, type);
    }
    private Animal setParameters (Animal animal, Enum type){
        animal.setWeight((Float) Settings.weights[ArraySearch.externalIndex(Settings.weights, type, 0)][1]);
        animal.setSaturationWeight((Float) Settings.foodWeight[ArraySearch.externalIndex(Settings.foodWeight, type, 0)][1]);
        animal.setSpeed((int) Settings.speeds[ArraySearch.externalIndex(Settings.speeds, type, 0)][1]);
        animal.setMaxDayWithoutFood((int) Settings.maxDaysWithoutFood[ArraySearch.externalIndex(Settings.maxDaysWithoutFood, type, 0)][1]);
        animal.setProbabilitiesOfEating(ArraySort.sort((Object[][]) Settings.probabilitiesOfEating[ArraySearch.externalIndex(Settings.probabilitiesOfEating, type, 0)][1], 1));
        animal.setType(type);

        return animal;
    }
}
