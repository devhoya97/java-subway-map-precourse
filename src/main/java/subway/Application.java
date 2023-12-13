package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Station upBound = new Station("잠실역");
        Station downBound = new Station("수진역");
        Station newStation = new Station("신흥역");

        StationRepository.addStation(upBound);
        StationRepository.addStation(downBound);
        StationRepository.addStation(newStation);

        Line line = new Line("8호선", upBound, downBound);
        line.addStation(newStation, upBound, downBound);

        System.out.println(line.getStations());
    }
}
