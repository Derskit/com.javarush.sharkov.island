package entity;

import enums.Direction;
import enums.HerbivoreType;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Predator;
import enums.PredatorType;
import repository.Fabrics;
import util.MapLocation;
import config.Settings;
import util.Random;

public abstract class Animal implements Eatable {
    int speed;

    float saturationWeight;

    Object[][] probabilitiesOfEating;

    int dayWithoutFood = 0;
    int maxDayWithoutFood;

    private boolean isEat = false;

    private float weightFood = 0;

    Enum type = null;

    boolean isDead = false;

    int coordinateX = 0;
    int coordinateY = 0;

    float weight = 0;

    public int getSpeed() {
        return speed;
    }

    public float getSaturationWeight() {
        return saturationWeight;
    }

    public Object[][] getProbabilitiesOfEating() {
        return probabilitiesOfEating;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSaturationWeight(float saturationWeight) {
        this.saturationWeight = saturationWeight;
    }

    public void setProbabilitiesOfEating(Object[][] probabilitiesOfEating) {
        this.probabilitiesOfEating = probabilitiesOfEating;
    }

    public void setMaxDayWithoutFood(int maxDayWithoutFood) {
        this.maxDayWithoutFood = maxDayWithoutFood;
    }

    public void eat() {
        isEat = false;
        for (int i = 0; i < Island.getLocations()[coordinateX][coordinateY].getEatables().size(); i++) {
            for (int j = probabilitiesOfEating.length; j >= 0; j--) {
                Eatable eatable = (Eatable) probabilitiesOfEating[j][0];
                int probabilityEat = (int) probabilitiesOfEating[j][1];
                if (eatable.getType() == Island.getLocations()[coordinateX][coordinateY].getEatables().get(i).getType()) {
                    if (probabilityEat > Random.getRandom(100)) {
                        weightFood += Island.getLocations()[coordinateX][coordinateY].getEatables().get(i).getWeight();
                        Island.getLocations()[coordinateX][coordinateY].getEatables().remove(i);
                        if (weightFood >= saturationWeight) {
                            dayWithoutFood = 0;
                            weightFood = 0;
                        } else {
                            dayWithoutFood += 1;
                        }
                        System.out.println("eat");
                    } else {
                        dayWithoutFood += 1;
                    }
                    isEat = true;
                    break;
                }
            }
            if (isEat) {
                break;
            }
        }
        if (maxDayWithoutFood >= dayWithoutFood) {
            isDead = true;
        }
    }

    public void reproduction() {
        if (Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(type) < MapLocation.arrayToMap(Settings.maxEatables).get(type) && dayWithoutFood <= maxDayWithoutFood / 2) {
            for (Eatable eatable : Island.getLocations()[coordinateX][coordinateY].getEatables()) {
                if (!eatable.getType().equals(Plant.PlantType.PLANT)) {
                    Animal animal = (Animal) eatable;
                    if (animal.dayWithoutFood <= animal.maxDayWithoutFood) {
                        Island.getLocations()[coordinateX][coordinateY].isLock = true;
                        Island.getLocations()[coordinateX][coordinateY].getEatables()
                                .add(animal instanceof Predator ?
                                        Fabrics.getFabric().createPredator(PredatorType.randomPredatorType()) :
                                        Fabrics.getFabric().createHerbivores(HerbivoreType.randomHerbivoreType()));
                        MapLocation.addInMap(type, Island.getLocations()[coordinateX][coordinateY].getQuantityEatables());
                        Island.getLocations()[coordinateX][coordinateY].isLock = false;
                        System.out.println("reproduction");
                    }
                }
            }
        }
    }

    public void move() {
        int motions = Random.getRandom(speed);
        Direction direction = Direction.rnd();

        int newX = coordinateX + direction.dirX * motions;
        int newY = coordinateY + direction.dirY * motions;

        if (!(newX < 0 || newX >= Settings.xMapIsland || newY < 0 || newY >= Settings.yMapIsland)
            && Island.getLocations()[newX][newY].getQuantityEatables().get(type) < MapLocation.arrayToMap(Settings.maxEatables).get(type)
            && !Island.getLocations()[newX][newY].isLock){
            Island.getLocations()[newX][newY].isLock = true;
            Island.getLocations()[newX][newY].getEatables().add(this);
            MapLocation.addInMap(type, Island.getLocations()[newX][newY].getQuantityEatables());
            this.coordinateX = newX;
            this.coordinateY = newY;
            Island.getLocations()[coordinateX][coordinateY].getEatables().remove(this);
            MapLocation.removeInMap(type, Island.getLocations()[coordinateX][coordinateY].getQuantityEatables());
            Island.getLocations()[newX][newY].isLock = false;
            System.out.println("move");
        }
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }

    public Enum getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
