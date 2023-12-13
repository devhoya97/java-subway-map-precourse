package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.command.Command;
import subway.domain.command.LineManageCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionManageCommand;
import subway.domain.command.StationManageCommand;
import subway.domain.view.InputView;
import subway.domain.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final OutputView outputView = new OutputView();
    private static Mode currentMode = Mode.MAIN;

    public static void main(String[] args) {
        initializeSubwayRouteMap();
        while (currentMode != Mode.QUIT) {
            if (currentMode == Mode.MAIN) {
                runMainFunction();
                continue;
            }
            if (currentMode == Mode.STATION_MANAGE) {
                runStationManage();
                continue;
            }
            if (currentMode == Mode.LINE_MANAGE) {
                runLineManage();
                continue;
            }
            if (currentMode == Mode.SECTION_MANGE) {
                runSectionManage();
                continue;
            }
            if (currentMode == Mode.PRINT_SUBWAY_ROUTE_MAP) {
                outputView.printSubwayRouteMap();
                currentMode = Mode.MAIN;
            }
        }
    }

    public static void runMainFunction() {
        Command mainCommand = inputView.getValidMainCommand();
        if (mainCommand == MainCommand.STATION_MANAGE) {
            currentMode = Mode.STATION_MANAGE;
            return;
        }
        if (mainCommand == MainCommand.LINE_MANAGE) {
            currentMode = Mode.LINE_MANAGE;
            return;
        }
        if (mainCommand == MainCommand.SECTION_MANAGE) {
            currentMode = Mode.SECTION_MANGE;
            return;
        }
        if (mainCommand == MainCommand.PRINT_SUBWAY_ROUTE_MAP) {
            currentMode = Mode.PRINT_SUBWAY_ROUTE_MAP;
            return;
        }
        if (mainCommand == MainCommand.QUIT) {
            currentMode = Mode.QUIT;
        }
    }

    private static void runStationManage() {
        Command stationManageCommand = inputView.getValidStationManageCommand();
        if (stationManageCommand == StationManageCommand.REGISTER) {
            inputView.registerStation();
            currentMode = Mode.MAIN;
            return;
        }
        if (stationManageCommand == StationManageCommand.DELETE) {
            inputView.deleteStationByInput();
            currentMode = Mode.MAIN;
            return;
        }
        if (stationManageCommand == StationManageCommand.LOOK_UP) {
            outputView.printStationList();
            currentMode = Mode.MAIN;
            return;
        }
        if (stationManageCommand == StationManageCommand.BACK) {
            currentMode = Mode.MAIN;
        }
    }

    private static void runLineManage() {
        Command lineManageCommand = inputView.getValidLineManageCommand();
        if (lineManageCommand == LineManageCommand.REGISTER) {
            inputView.registerLine();
            currentMode = Mode.MAIN;
            return;
        }
        if (lineManageCommand == LineManageCommand.DELETE) {
            inputView.deleteLineByInput();
            currentMode = Mode.MAIN;
            return;
        }
        if (lineManageCommand == LineManageCommand.LOOK_UP) {
            outputView.printLineList();
            currentMode = Mode.MAIN;
            return;
        }
        if (lineManageCommand == LineManageCommand.BACK) {
            currentMode = Mode.MAIN;
        }
    }

    private static void runSectionManage() {
        Command sectionManageCommand = inputView.getValidSectionManageCommand();
        if (sectionManageCommand == SectionManageCommand.REGISTER) {
            inputView.registerSection();
            currentMode = Mode.MAIN;
            return;
        }
        if (sectionManageCommand == SectionManageCommand.DELETE) {
            inputView.deleteSectionByInput();
            currentMode = Mode.MAIN;
            return;
        }
        if (sectionManageCommand == SectionManageCommand.BACK) {
            currentMode = Mode.MAIN;
        }
    }

    private static void initializeSubwayRouteMap() {
        initializeStations();
        initializeLine2();
        initializeLine3();
        initializeShinbundangLine();
    }

    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void initializeLine2() {
        Station upBoundStation = StationRepository.findStation("교대역");
        Station downBoundStation = StationRepository.findStation("역삼역");
        Line line2 = new Line("2호선", upBoundStation, downBoundStation);
        line2.addStation(StationRepository.findStation("강남역"), 2);

        LineRepository.addLine(line2);
    }

    private static void initializeLine3() {
        Station upBoundStation = StationRepository.findStation("교대역");
        Station downBoundStation = StationRepository.findStation("매봉역");
        Line line3 = new Line("3호선", upBoundStation, downBoundStation);
        line3.addStation(StationRepository.findStation("남부터미널역"), 2);
        line3.addStation(StationRepository.findStation("양재역"), 3);

        LineRepository.addLine(line3);
    }

    private static void initializeShinbundangLine() {
        Station upBoundStation = StationRepository.findStation("강남역");
        Station downBoundStation = StationRepository.findStation("양재시민의숲역");
        Line ShinbundangLine = new Line("신분당선", upBoundStation, downBoundStation);
        ShinbundangLine.addStation(StationRepository.findStation("양재역"), 2);

        LineRepository.addLine(ShinbundangLine);
    }
}
