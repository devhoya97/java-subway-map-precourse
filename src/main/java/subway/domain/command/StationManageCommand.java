package subway.domain.command;

public enum StationManageCommand implements Command {
    REGISTER("1", "역 등록"),
    DELETE("2", "역 삭제"),
    LOOK_UP("3", "역 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    StationManageCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    @Override
    public String get() {
        return command;
    }

    @Override
    public String getName() {
        return name;
    }
}
