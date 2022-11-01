package onboarding.problem6;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (!isKorean(name)) {
            throw new IllegalArgumentException("한글만 입력 가능합니다.");
        }
        if (!isValideLength(name)) {
            throw new IllegalArgumentException("전체 길이는 1자 이상 20자 미만 가능합니다.");
        }
    }

    private boolean isValideLength(String name) {
        return name.length() > 1 && (name.length()) < 20;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private boolean isKorean(String name) {
        return Pattern.matches("^[가-힣]*$", name);
    }
}
