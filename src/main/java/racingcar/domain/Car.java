package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constants.NumberConstants.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MINIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MOVE_CONDITION_NUMBER;

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

    public void moveOrNot(int round) {
        if (isMoveCondition()) {
            move(round);
            return;
        }
        notMove(round);
    }

    private boolean isMoveCondition() {
        return pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER)
                >= MOVE_CONDITION_NUMBER;
    }

    public void move(int round) {
        roundScore.put(round, ++totalScore); // 직진
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
