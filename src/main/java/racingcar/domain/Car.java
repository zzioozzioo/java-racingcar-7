package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private final String carName;
    private final Map<Integer, Integer> roundScore;
    private int totalScore;

    public Car(String carName) {
        this.carName = carName;
        this.roundScore = new HashMap<>();
        this.totalScore = 0;
    }

    public void move(int round) {
        totalScore++;
        roundScore.put(round, totalScore); // 직진
    }

    public void notMove(int round) {
        roundScore.put(round, totalScore); // 직진 X
    }

    public String getCarName() {
        return carName;
    }

    public Map<Integer, Integer> getRoundScore() {
        return roundScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
