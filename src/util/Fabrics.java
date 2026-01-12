package util;

import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

public class Fabrics {
    private static final Fabrics fabric = new Fabrics();

    public static Fabrics getFabric() {
        return fabric;
    }

    public Plant createPlant(){
        return new Plant();
    }
    public Predator createPredator(PredatorType type){
        Predator predator = null;

        switch (type){
            case FOX -> predator = new Fox();
            case BEAR -> predator = new Bear();
            case WOLF -> predator = new Wolf();
            case EAGLE -> predator = new Eagle();
            case BOA_CONSTRICTOR -> predator = new BoaConstrictor();
        }
        predator.setType(type);
        return predator;
    }
    public Herbivores createHerbivores(HerbivoreType type){
        Herbivores herbivores = null;

        switch (type){
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
        herbivores.setType(type);
        return herbivores;
    }
}
