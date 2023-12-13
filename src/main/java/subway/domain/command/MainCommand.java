package subway.domain.command;

public enum MainCommand implements Command {
    STATION_MANAGE("1", "역 관리"),
    LINE_MANAGE("2", "노선 관리"),
    SECTION_MANAGE("3", "구간 관리"),
    PRINT_SUBWAY_ROUTE_MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String command;
    private final String name;

    MainCommand(String command, String name) {
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
