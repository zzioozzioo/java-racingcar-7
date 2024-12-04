package racingcar.config;

import racingcar.io.InputView;
import racingcar.io.reader.MissionUtilsReader;
import racingcar.io.reader.Reader;
import racingcar.io.writer.SystemWriter;
import racingcar.io.writer.Writer;

public class AppConfig {

    private final Reader reader;
    private final Writer writer;

    private final InputView inputView;

    public AppConfig() {
        this.reader = getReader();
        this.writer = getWriter();

        this.inputView = getInputView();
    }

    private Reader getReader() {
        return new MissionUtilsReader();
    }

    private Writer getWriter() {
        return new SystemWriter();
    }

    private InputView getInputView() {
        return new InputView(this.reader, this.writer);
    }
}
