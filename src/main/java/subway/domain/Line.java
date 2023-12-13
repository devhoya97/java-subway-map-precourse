package subway.domain;

import java.util.Objects;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;
    private String name;

    public Line(String name) {
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("노선 이름의 최소 길이는 " + MIN_NAME_LENGTH + "입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(Line line) {
        return Objects.equals(this.name, line.name);
    }

    // 추가 기능 구현
}
