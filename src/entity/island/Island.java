package entity.island;

import entity.Animal;
import entity.herbivore.HerbivoreType;
import entity.predator.PredatorType;
import util.AddInMap;
import repository.Fabrics;
import util.Random;
import config.Settings;

public class Island {

    public static int motion;
    static Location[][] locations;

    public static Location[][] getLocations() {
        return locations;
    }

    public Island(int x, int y){

        motion = 0;
        locations = new Location[x][y];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
        for (int i = 0; i < Settings.minHerbivore + Settings.minPredator; i++) {
            int rndX = Random.getRandom(x);
            int rndY = Random.getRandom(y);
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
