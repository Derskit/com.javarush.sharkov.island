package entity;

import util.AddInMap;
import config.Settings;

public class Animal extends Eatable{
    int speed;
    float saturationWeight;
    Object[][] probabilitiesOfEating;
    int motionWithoutFood = 0;
    int deathMotion = 3;

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

    public void eat(){
        //ArrayList arrayList = coordinates.getEatables();
        for (int i = coordinates.getEatables().size(); i <= 0; i--) {

        }
    }
    public void reproduction(){
        if (coordinates.getQuantityEatables().get(type) < AddInMap.arrayToMap(Settings.maxEatables).get(type)){}
    }
    public void move(){

    }
    public void death(){}
}
