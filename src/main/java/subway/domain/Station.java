package subway.domain;

import java.util.Objects;

public class Station {
    private static final int MIN_NAME_LENGTH = 2;
    private final String name;
    private boolean isInLine = false;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("역 이름의 길이가 유효하지 않습니다.");
        }
    }

    public boolean match(String name) {
        return Objects.equals(this.name, name);
    }

    public void setInLine() {
        isInLine = true;
    }

    public void deleteInLine() {
        isInLine = false;
    }

    public boolean isInLine() {
        return isInLine;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Station station = (Station) object;

        return name.equals(station.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
