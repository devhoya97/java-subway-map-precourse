package subway.domain.command;

public enum SectionManageCommand implements Command {
    REGISTER("1", "구간 등록"),
    DELETE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    SectionManageCommand(String command, String name) {
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
