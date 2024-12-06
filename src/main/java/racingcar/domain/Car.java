package racingcar.domain;

public class Car {

    private final String carName;
    private int score;

    public Car(String carName) {
        this.carName = carName;
        this.score = 0;
    }

    public void go() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
