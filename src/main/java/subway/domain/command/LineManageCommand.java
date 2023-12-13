package subway.domain.command;

public enum LineManageCommand implements Command {
    REGISTER("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    LOOK_UP("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    LineManageCommand(String command, String name) {
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
