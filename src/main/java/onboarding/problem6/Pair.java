package onboarding.problem6;

import java.util.List;

public class Pair {
    private final List<String> content;
    Pair(List<String> content) {
        this.content = content;
    }

    String getName() {
        return content.get(1);
    }

    String getEmail() {
        return content.get(0);
    }
}
