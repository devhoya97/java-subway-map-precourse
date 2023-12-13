package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplication(station);
        stations.add(station);
    }

    private static void validateDuplication(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("추가하려는 역 이름이 중복됩니다.");
        }
    }

    public static void deleteStation(String name) throws IllegalArgumentException {
        Station station = findStation(name);

        if (station.isInLine()) {
            throw new IllegalArgumentException(station.getName() + "은 노선에 포함되어 있어 제거가 불가합니다.");
        }

        stations.remove(station);
    }

    public static Station findStation(String name) {
        for (Station station : stations) {
            if (station.match(name)) {
                return station;
            }
        }

        throw new IllegalArgumentException(name + "은 등록된 역이 아닙니다.");
    }
}
