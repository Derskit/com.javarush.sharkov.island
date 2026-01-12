package entity.island;

import entity.Animal;
import entity.Eatable;
import entity.herbivore.HerbivoreType;
import entity.predator.PredatorType;
import util.Fabrics;
import util.Settings;

import java.util.Map;
import java.util.Random;

public class Island {
    private final Fabrics fabric;

    Location[][] locations;

    public Island(Fabrics fabric, int x, int y){
        this.fabric = fabric;
        locations = new Location[x][y];
        Random rnd = new Random();
        for (int i = 0; i < Settings.minHerbivore + Settings.minPredator; i++) {
            int rndX = rnd.nextInt(x);
            int rndY = rnd.nextInt(y);
            if (i < Settings.minHerbivore){
                Animal entity = fabric.createHerbivores(HerbivoreType.randomHerbivoreType());
                entity.setX(rndX);
                entity.setY(rndY);
                locations[rndX][rndY].eatables.add(entity);
            }
            else {
                Animal entity = fabric.createPredator(PredatorType.randomPredatorType());
                entity.setX(rndX);
                entity.setY(rndY);
                locations[rndX][rndY].eatables.add(entity);
            }
        }
    }
}
