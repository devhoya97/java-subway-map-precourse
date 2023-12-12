package subway;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Station station1 = new Station("잠실역");
        Station station2 = new Station("잠실역");

        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
    }
}
