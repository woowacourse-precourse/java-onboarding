package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class TokenGenerator {
    private final List<String> tokens;

    public TokenGenerator(String word) {
        this.tokens = splitToken(word);
    }

    private List<String> splitToken(String nickname) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            tokens.add(nickname.substring(i, i + 2));
        }
        return tokens;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
