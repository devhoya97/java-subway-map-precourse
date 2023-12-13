package subway.domain.view;

import java.util.Objects;
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

public class InputView {
    private final OutputView outputView = new OutputView();
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Command getValidMainCommand() {
        outputView.printMainScreen();
        while (true) {
            try {
                return getMainCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private Command getMainCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        for (Command mainCommand : MainCommand.values()) {
            if (Objects.equals(mainCommand.get(), input)) {
                return mainCommand;
            }
        }

        throw new IllegalArgumentException("준비된 기능이 아닙니다.");
    }

    public Command getValidStationManageCommand() {
        outputView.printStationManageScreen();
        while (true) {
            try {
                return getStationManageCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private Command getStationManageCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        for (Command stationManageCommand : StationManageCommand.values()) {
            if (Objects.equals(stationManageCommand.get(), input)) {
                return stationManageCommand;
            }
        }

        throw new IllegalArgumentException("준비된 기능이 아닙니다.");
    }

    public Station getStationWithRegister() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        while (true) {
            try {
                Station station = new Station(scanner.nextLine().trim());
                StationRepository.addStation(station);
                outputView.printInfoMessage("지하철 역이 등록되었습니다.");
                return station;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public void deleteStationByInput() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                StationRepository.deleteStation(input);
                return;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public Command getValidLineManageCommand() {
        outputView.printLineManageScreen();
        while (true) {
            try {
                return getLineManageCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private Command getLineManageCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        for (Command lineManageCommand : LineManageCommand.values()) {
            if (Objects.equals(lineManageCommand.get(), input)) {
                return lineManageCommand;
            }
        }

        throw new IllegalArgumentException("준비된 기능이 아닙니다.");
    }

    public Line getLineWithRegister() {
        while (true) {
            try {
                return new Line(getLineName(), getUpBoundStation(), getDownBoundStation());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private String getLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");

        String lineName = scanner.nextLine().trim();
        Line.validateName(lineName);

        return lineName;
    }

    private Station getUpBoundStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");

        return StationRepository.findStation(scanner.nextLine().trim());
    }

    private Station getDownBoundStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");

        return StationRepository.findStation(scanner.nextLine().trim());
    }

    public void deleteLineByInput() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");

        while (true) {
            try {
                LineRepository.deleteLineByName(scanner.nextLine().trim());
                outputView.printInfoMessage("지하철 노선이 삭제되었습니다.");
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public Command getValidSectionManageCommand() {
        outputView.printSectionManageScreen();
        while (true) {
            try {
                return getSectionManageCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private Command getSectionManageCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        for (Command sectionManageCommand : SectionManageCommand.values()) {
            if (Objects.equals(sectionManageCommand.get(), input)) {
                return sectionManageCommand;
            }
        }

        throw new IllegalArgumentException("준비된 기능이 아닙니다.");
    }
}
