package entity.island;

import entity.Animal;
import entity.herbivore.Herbivores;
import entity.predator.Predator;
import enums.HerbivoreType;
import enums.PredatorType;
import util.MapLocation;
import repository.Fabrics;
import util.Random;
import config.Settings;

import java.util.Map;

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
        Map<Enum, Integer> animalsWhenCreating = MapLocation.arrayToMap(Settings.minEatables);
        for (HerbivoreType animal:HerbivoreType.values()){
            for (int i = 0; i < animalsWhenCreating.get(animal); i++) {
                animalAccommodation(Fabrics.getFabric().createHerbivores(animal));
            }
        }
        for (PredatorType animal:PredatorType.values()){
            for (int i = 0; i < animalsWhenCreating.get(animal); i++) {
                animalAccommodation(Fabrics.getFabric().createPredator(animal));
            }
        }
    }

    private void animalAccommodation(Animal entity) {
        int rndX = Random.getRandom(Settings.xMapIsland);
        int rndY = Random.getRandom(Settings.yMapIsland);
        if (locations[rndX][rndY].getQuantityEatables().get(entity.getType()).size() < MapLocation.arrayToMap(Settings.maxEatables).get(entity.getType())){
            entity.setX(rndX);
            entity.setY(rndY);
            locations[rndX][rndY].getQuantityEatables().get(entity.getType()).add(entity);
        }
    }
}
