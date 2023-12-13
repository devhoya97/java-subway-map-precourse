package subway.domain.view;

import java.util.Objects;
import java.util.Scanner;
import subway.domain.command.Command;
import subway.domain.command.MainCommand;

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
        outputView.printMessage("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        for (Command mainCommand : MainCommand.values()) {
            if (Objects.equals(mainCommand.get(), input)) {
                return mainCommand;
            }
        }

        throw new IllegalArgumentException("준비된 기능이 아닙니다.");
    }

}
