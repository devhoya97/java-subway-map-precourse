package subway.domain.view;

import java.util.Objects;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.command.Command;
import subway.domain.command.MainCommand;
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

    public Station getStationForRegister() {
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

}
