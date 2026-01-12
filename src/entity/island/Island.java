package entity.island;

import entity.Animal;
import entity.Eatable;
import entity.herbivore.HerbivoreType;
import entity.predator.PredatorType;
import util.AddInMap;
import util.Fabrics;
import util.Settings;

import java.util.Map;
import java.util.Random;

public class Island {

    static Location[][] locations;

    public static Location[][] getLocations() {
        return locations;
    }

    public Island(int x, int y){

        locations = new Location[x][y];
        Random rnd = new Random();
        for (int i = 0; i < Settings.minHerbivore + Settings.minPredator; i++) {
            int rndX = rnd.nextInt(x);
            int rndY = rnd.nextInt(y);
            if (i < Settings.minHerbivore){
                Animal entity = Fabrics.getFabric().createHerbivores(HerbivoreType.randomHerbivoreType());
                entity.setX(rndX);
                entity.setY(rndY);
                AddInMap.addInMap(entity, locations[rndX][rndY].quantityEatables);
                locations[rndX][rndY].eatables.add(entity);
            }
            else {
                Animal entity = Fabrics.getFabric().createPredator(PredatorType.randomPredatorType());
                entity.setX(rndX);
                entity.setY(rndY);
                AddInMap.addInMap(entity, locations[rndX][rndY].quantityEatables);
                locations[rndX][rndY].eatables.add(entity);
            }
        }
    }
}
