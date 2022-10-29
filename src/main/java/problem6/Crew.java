package problem6;

import java.util.List;
import java.util.stream.IntStream;

public class Crew {

    public static final int EMAIL_INDEX = 0;
    public static final int NICKNAME_INDEX = 1;
    public static final int LOOP_START_INDEX_ZERO = 0;
    public static final int DUPLICATE_PATTERN_SIZE = 2;

    private final String email;
    private final String nickname;

    public Crew(List<String> crewInfo) {
        this.email = crewInfo.get(EMAIL_INDEX);
        this.nickname = crewInfo.get(NICKNAME_INDEX);
    }

    public boolean isDuplicateNickname(Crew otherCrew) {
        return IntStream.range(LOOP_START_INDEX_ZERO, calculateRange())
                .mapToObj(this::substringPattern)
                .anyMatch(otherCrew::isContainsNickname);
    }

    private int calculateRange() {
        return (nickname.length() - (DUPLICATE_PATTERN_SIZE - 1));
    }

    private String substringPattern(int index) {
        return nickname.substring(index, index + DUPLICATE_PATTERN_SIZE);
    }

    private boolean isContainsNickname(String pattern) {
        return nickname.contains(pattern);
    }
}
