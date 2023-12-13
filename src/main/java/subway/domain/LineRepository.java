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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
