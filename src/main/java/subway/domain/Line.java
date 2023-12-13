package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;
    private final String name;
    private final List<Station> stations = new LinkedList<>();

    public Line(String name, Station upBoundStation, Station downBoundStation) {
        this.name = name;
        stations.add(upBoundStation);
        stations.add(downBoundStation);
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("노선 이름의 최소 길이는 " + MIN_NAME_LENGTH + "입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(Line line) {
        return Objects.equals(this.name, line.name);
    }

    // 추가 기능 구현
}
