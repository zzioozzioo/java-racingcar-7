package racingcar.io;

import static racingcar.constants.OutputMessages.FINAL_WINNER;
import static racingcar.constants.OutputMessages.RACE_RESULT_MESSAGE;
import static racingcar.constants.StringConstants.NEW_LINE;

import racingcar.io.writer.Writer;

public class OutputView {

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printResultMessage() {
        writer.write(RACE_RESULT_MESSAGE + NEW_LINE);
    }

    public void printOneRoundResult(String result) {
        writer.write(result);
    }

    public void printRaceResult(String result) {
        writer.write(String.format(FINAL_WINNER, result));
    }
}
