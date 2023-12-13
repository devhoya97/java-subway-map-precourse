package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line newLine) {
        validateDuplication(newLine);
        lines.add(newLine);
    }

    private static void validateDuplication(Line newLine) {
        for (Line line : lines) {
            if (line.isSameName(newLine)) {
                throw new IllegalArgumentException(newLine.getName() + "은 이미 등록된 노선 이름입니다.");
            }
        }
    }

    public static void deleteLineByName(String name) throws IllegalArgumentException {
        Line line = findLineByName(name);

        lines.remove(line);
    }

    public static Line findLineByName(String name) {
        for (Line line : lines) {
            if (Objects.equals(line.getName(), name)) {
                return line;
            }
        }

        throw new IllegalArgumentException(name + "은 등록된 노선이 아닙니다.");
    }
}
