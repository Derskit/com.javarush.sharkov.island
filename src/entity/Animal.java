package entity;

import util.AddInMap;
import config.Settings;
import util.Random;

public class Animal extends Eatable{
    int speed;
    float saturationWeight;
    Object[][] probabilitiesOfEating;
    int motionWithoutFood = 0;
    int maxMotionWithoutFood;
    boolean isLock = false;
    private boolean isEat = false;
    private float weightFood = 0;

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

    public void setMaxMotionWithoutFood(int maxMotionWithoutFood) {
        this.maxMotionWithoutFood = maxMotionWithoutFood;
    }

    public void eat(){
        isEat = false;
        for(int i = 0; i < coordinates.getEatables().size(); i++) {
            for (int j = probabilitiesOfEating.length; j >= 0; j--) {
                Eatable eatable = (Eatable) probabilitiesOfEating[j][0];
                int probabilityEat = (int) probabilitiesOfEating[j][1];
                if (eatable.getType() == coordinates.getEatables().get(i).getType() && !coordinates.getEatables().get(i).getIsLock()){
                    coordinates.getEatables().get(i).setLock(true);
                    if (probabilityEat > Random.getRandom(100)){
                        weightFood += coordinates.getEatables().get(i).getWeight();
                        coordinates.getEatables().remove(i);
                        if (weightFood >= saturationWeight){
                            motionWithoutFood = 0;
                            weightFood = 0;
                        }
                        else {
                            motionWithoutFood += 1;
                        }
                    }
                    else {
                        coordinates.getEatables().get(i).setLock(false);
                        motionWithoutFood += 1;
                    }
                    isEat = true;
                    break;
                }
            }
            if (isEat){break;}
        }
        if (maxMotionWithoutFood >= motionWithoutFood){
            isDead = true;
            isLock = true;
        }
    }
    public void reproduction(){
        if (coordinates.getQuantityEatables().get(type) < AddInMap.arrayToMap(Settings.maxEatables).get(type)){}
    }
    public void move(){

    }
}
