package entity;

import enums.Direction;
import enums.HerbivoreType;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Predator;
import enums.PredatorType;
import exception.AnimalEatingException;
import repository.Fabrics;
import util.MapLocation;
import config.Settings;
import util.Random;

public abstract class Animal implements Eatable {
    private int speed;

    private float saturationWeight;

    private Object[][] probabilitiesOfEating;

    private int dayWithoutFood = 0;
    private int maxDayWithoutFood;

    private boolean isEat = false;

    private float weightFood = 0;

    private Enum type = null;

    private boolean isDead = false;

    private int coordinateX = 0;
    private int coordinateY = 0;

    private float weight = 0;

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
        for (int j = probabilitiesOfEating.length - 1; j >= 0; j--) {
            if (isEat) {break;}
            Enum typeFood = (Enum) probabilitiesOfEating[j][0];
            for (int i = 0; i < Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(typeFood).size(); i++) {
                int probabilityEat = (int) probabilitiesOfEating[j][1];
                try {
                    if (Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(typeFood).size() > 0
                            && typeFood.equals(Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(typeFood).get(i).getType())) {
                        if (100 - probabilityEat <= Random.getRandom(100)) {
                            weightFood += Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(typeFood).get(i).getWeight();
                            Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(typeFood).remove(i);
                            if (weightFood >= saturationWeight) {
                                dayWithoutFood = 0;
                                weightFood = 0;
                            } else {
                                dayWithoutFood += 1;
                            }
                        }
                        isEat = true;
                        break;
                    }
                } catch (Exception e) {
                    throw new AnimalEatingException(Settings.animalExceptionMessage);
                }
            }
        }
        if (!isEat){
            dayWithoutFood += 1;
        }
        if (maxDayWithoutFood <= dayWithoutFood) {
            isDead = true;
        }
    }

    public void reproduction() {
        if (Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(type).size() < MapLocation.arrayToMap(Settings.maxEatables).get(type)
                && Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(type).size() > 1 && dayWithoutFood < maxDayWithoutFood/2) {
            Island.getLocations()[coordinateX][coordinateY].isLock = true;
            Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(type)
                    .add(this instanceof Predator ?
                            Fabrics.getFabric().createPredator((PredatorType) type) :
                            Fabrics.getFabric().createHerbivores((HerbivoreType) type));
            Island.getLocations()[coordinateX][coordinateY].isLock = false;
        }
    }

    public void move() {
        int motions = Random.getRandom(speed);
        Direction direction = Direction.rnd();

        int newX = coordinateX + direction.dirX * motions;
        int newY = coordinateY + direction.dirY * motions;

        if (!(newX < 0 || newX >= Settings.xMapIsland || newY < 0 || newY >= Settings.yMapIsland)
                && Island.getLocations()[newX][newY].getQuantityEatables().get(type).size() < MapLocation.arrayToMap(Settings.maxEatables).get(type)
                && !Island.getLocations()[newX][newY].isLock) {
            Island.getLocations()[newX][newY].isLock = true;
            Island.getLocations()[newX][newY].getQuantityEatables().get(type).add(this);
            this.coordinateX = newX;
            this.coordinateY = newY;
            Island.getLocations()[coordinateX][coordinateY].getQuantityEatables().get(type).remove(this);
            Island.getLocations()[newX][newY].isLock = false;
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
