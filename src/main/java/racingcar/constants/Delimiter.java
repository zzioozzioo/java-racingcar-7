package racingcar.constants;

public enum Delimiter {
    COMMA(",", "쉼표");

    private final String delimiter;
    private final String name;


    Delimiter(String delimiter, String name) {
        this.delimiter = delimiter;
        this.name = name;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getName() {
        return name;
    }
}
