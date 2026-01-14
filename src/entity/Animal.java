package entity;

public class Animal extends Eatable{
    int speed;
    float saturationWeight;
    Object[] probabilitiesOfEating;

    public int getSpeed() {
        return speed;
    }
    public float getSaturationWeight() {
        return saturationWeight;
    }
    public Object[] getProbabilitiesOfEating() {
        return probabilitiesOfEating;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setSaturationWeight(float saturationWeight) {
        this.saturationWeight = saturationWeight;
    }
    public void setProbabilitiesOfEating(Object[] probabilitiesOfEating) {
        this.probabilitiesOfEating = probabilitiesOfEating;
    }

    public void eat(){}
    public void reproduction(){}
    public void move(){}
    public void death(){}
}
