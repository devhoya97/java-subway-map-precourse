package subway.domain;

public class Station {
    private static final int MIN_NAME_LENGTH = 2;
    private String name;

    public Station(String name) {
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("역 이름의 길이가 유효하지 않습니다.");
        }
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
