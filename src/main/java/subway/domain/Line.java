package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MIN_STATIONS_SIZE = 2;

    private final String name;
    private final List<Station> stations = new LinkedList<>();

    public Line(String name, Station upBoundStation, Station downBoundStation) {
        validateName(name);
        this.name = name;
        stations.add(upBoundStation);
        stations.add(downBoundStation);
    }

    public static void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("노선 이름의 최소 길이는 " + MIN_NAME_LENGTH + "입니다.");
        }
    }

    public void addStation(Station newStation, int order) {
        validateIsStationNotInLine(newStation);
        validateOrder(order);
        stations.add(order - 1, newStation);
    }

    private void validateIsStationNotInLine(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(station.getName() + "은 이미 노선에 포함되어 있습니다.");
        }
    }

    private void validateOrder(int order) {
        if (order < 0 || order > stations.size()) {
            throw new IllegalArgumentException("등록하려는 구간의 순서가 유효하지 않습니다.");
        }
    }

    public void deleteStation(Station station) {
        validateStationsSize();
        validateIsStationInLine(station);

        stations.remove(station);
    }

    private void validateStationsSize() {
        if (stations.size() == MIN_STATIONS_SIZE) {
            throw new IllegalArgumentException("노선은 최소 " + MIN_STATIONS_SIZE + "개의 역을 가져야 합니다.");
        }
    }

    private void validateIsStationInLine(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(station.getName() + "은 노선에 포함되어 있지 않습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(Line line) {
        return Objects.equals(this.name, line.name);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    // 추가 기능 구현
}
