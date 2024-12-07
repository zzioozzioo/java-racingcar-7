package racingcar.io.parser;

import static racingcar.constants.OutputMessages.ONE_ROUND_RESULT_FORMAT;
import static racingcar.constants.StringConstants.DASH;
import static racingcar.constants.StringConstants.NEW_LINE;
import static racingcar.constants.StringConstants.ONE_BLANK;

import java.util.List;
import java.util.Map;
import racingcar.constants.Delimiter;
import racingcar.domain.Car;

public class ResultParser {

    public String parseOneRoundResult(List<Car> cars, int round) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            Map<Integer, Integer> roundScore = car.getRoundScore();
            sb.append(String.format(ONE_ROUND_RESULT_FORMAT, car.getCarName()))
                    .append(DASH.repeat(roundScore.get(round)))
                    .append(NEW_LINE);
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    public String parseRaceResult(List<String> winners) {
        return String.join(Delimiter.COMMA.getDelimiter() + ONE_BLANK, winners)
                + NEW_LINE;
    }
}
