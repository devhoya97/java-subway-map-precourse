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

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
