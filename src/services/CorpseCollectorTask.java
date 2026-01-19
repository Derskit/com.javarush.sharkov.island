package services;

import config.Settings;
import entity.Animal;
import entity.Plant;
import entity.island.Island;

public class CorpseCollectorTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Settings.xMapIsland; i++) {
            for (int j = 0; j < Settings.yMapIsland; j++) {
                for(Enum key: Island.getLocations()[i][j].getQuantityEatables().keySet()){
                    for (int k = 0; k < Island.getLocations()[i][j].getQuantityEatables().get(key).size(); k++) {
                        if (!key.equals(Plant.PlantType.PLANT)) {
                            Animal animal = (Animal) Island.getLocations()[i][j].getQuantityEatables().get(key).get(k);
                            if (animal.getIsDead()){
                                Island.getLocations()[i][j].getQuantityEatables().get(key).remove(k);
                                System.out.println("__DEAD__");
                            }
                        }
                    }
                }
            }
        }
    }
}
