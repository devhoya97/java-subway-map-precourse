package subway.domain.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.command.Command;
import subway.domain.command.LineManageCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionManageCommand;
import subway.domain.command.StationManageCommand;

public class OutputView {

    public void printInfoMessage(String message) {
        System.out.println("[INFO] " + message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public void printMainScreen() {
        System.out.println("## 메인 화면");
        for (Command mainCommand : MainCommand.values()) {
            System.out.println(mainCommand.get() + ". " + mainCommand.getName());
        }
    }

    public void printStationManageScreen() {
        System.out.println("## 역 관리 화면");
        for (Command stationManageCommand : StationManageCommand.values()) {
            System.out.println(stationManageCommand.get() + ". " + stationManageCommand.getName());
        }
    }

    public void printLineManageScreen() {
        System.out.println("## 노선 관리 화면");
        for (Command lineManageCommand : LineManageCommand.values()) {
            System.out.println(lineManageCommand.get() + ". " + lineManageCommand.getName());
        }
    }

    public void printSectionManageScreen() {
        System.out.println("## 구간 관리 화면");
        for (Command sectionManageCommand : SectionManageCommand.values()) {
            System.out.println(sectionManageCommand.get() + ". " + sectionManageCommand.getName());
        }
    }

    public void printStationList() {
        System.out.println("## 역 목록");
        for (Station station : StationRepository.stations()) {
            printInfoMessage(station.getName());
        }
    }

    public void printLineList() {
        System.out.println("## 노선 목록");
        for (Line line : LineRepository.lines()) {
            printInfoMessage(line.getName());
        }
    }

    public void printSubwayRouteMap() {
        System.out.println("## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            printInfoMessage(line.getName());
            printInfoMessage("---");
            for (Station station : line.getStations()) {
                printInfoMessage(station.getName());
            }
            System.out.println();
        }
    }
}
