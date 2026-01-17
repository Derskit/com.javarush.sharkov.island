package entity.island;

import entity.Animal;
import enums.HerbivoreType;
import enums.PredatorType;
import util.MapLocation;
import repository.Fabrics;
import util.Random;
import config.Settings;

public class Island {

    public static int day;
    static Location[][] locations;

    public static Location[][] getLocations() {
        return locations;
    }

    public Island(int x, int y) {

        day = 0;
        locations = new Location[x][y];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
        for (int i = 0; i < Settings.minHerbivore + Settings.minPredator; i++) {
            int rndX = Random.getRandom(x);
            int rndY = Random.getRandom(y);
            if (i < Settings.minHerbivore) {
                Animal entity = Fabrics.getFabric().createHerbivores(HerbivoreType.randomHerbivoreType());
                entity.setX(rndX);
                entity.setY(rndY);
                MapLocation.addInMap(entity.getType(), locations[rndX][rndY].getQuantityEatables());
                locations[rndX][rndY].getEatables().add(entity);
            } else {
                Animal entity = Fabrics.getFabric().createPredator(PredatorType.randomPredatorType());
                entity.setX(rndX);
                entity.setY(rndY);
                MapLocation.addInMap(entity.getType(), locations[rndX][rndY].getQuantityEatables());
                locations[rndX][rndY].getEatables().add(entity);
            }
        }
    }
}
