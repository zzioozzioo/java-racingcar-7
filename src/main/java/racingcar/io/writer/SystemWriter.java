package racingcar.io.writer;

public class SystemWriter implements Writer {
    public void write(String value) {
        System.out.print(value);
    }
}
