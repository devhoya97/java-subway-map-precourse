package subway.domain.view;

import subway.domain.command.Command;
import subway.domain.command.MainCommand;
import subway.domain.command.StationManageCommand;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
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
}
