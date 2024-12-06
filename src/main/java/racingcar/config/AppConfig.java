package racingcar.config;

import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.io.parser.InputParser;
import racingcar.io.parser.ResultParser;
import racingcar.io.reader.MissionUtilsReader;
import racingcar.io.reader.Reader;
import racingcar.io.writer.SystemWriter;
import racingcar.io.writer.Writer;
import racingcar.service.RacingCarService;

public class AppConfig {

    private final Reader reader;
    private final Writer writer;

    public AppConfig() {
        this.reader = getReader();
        this.writer = getWriter();
    }

    private Reader getReader() {
        return new MissionUtilsReader();
    }

    private Writer getWriter() {
        return new SystemWriter();
    }

    public InputView getInputView() {
        return new InputView(this.reader, this.writer);
    }

    public OutputView getOutputView() {
        return new OutputView(this.writer);
    }

    public InputParser getInputParser() {
        return new InputParser();
    }

    public ResultParser getResultParser() {
        return new ResultParser();
    }

    public RacingCarService getService() {
        return new RacingCarService();
    }
}
