package lec10observer.weatherorama.ver2;

public class PollutionData extends Subject {
    private double pmValue;

    public double getPmValue() {
        return pmValue;
    }

    public void setPmValue(double pmValue) {
        this.pmValue = pmValue;
        notifyObservers();
    }
}