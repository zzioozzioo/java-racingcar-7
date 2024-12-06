package racingcar.io;

import static racingcar.constants.InputMessages.READ_CAR_NAMES_MESSAGES;
import static racingcar.constants.InputMessages.READ_TRY_COUNT;
import static racingcar.constants.StringConstants.NEW_LINE;

import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

public class InputView {

    private static final int NEW_LINE_COUNT = 2;

    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String readCarNames() {
        writer.write(READ_CAR_NAMES_MESSAGES);
        String inputCarNames = reader.readLine();
        writer.write(NEW_LINE);
        return inputCarNames;
    }

    public String readTryCount() {
        writer.write(READ_TRY_COUNT);
        String inputTryCount = reader.readLine();
        writer.write(NEW_LINE.repeat(NEW_LINE_COUNT));
        return inputTryCount;
    }
}
