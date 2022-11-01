package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TokenGenerator {
    private final List<String> tokens;

    public TokenGenerator(String word) {
        this.tokens = splitToken(word);
    }

    private List<String> splitToken(String nickname) {
        List<String> tokens = new ArrayList<>();
        IntStream.range(0, nickname.length() - 1).forEach(i -> tokens.add(nickname.substring(i, i + 2)));
        return tokens;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
