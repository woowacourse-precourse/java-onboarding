package onboarding.problem6;

import java.util.List;

public class SimilarityChecker {

    private final TokenMap tokenMap;
    private Deduplication deduplication;

    public SimilarityChecker() {
        this.tokenMap = new TokenMap();
    }

    public EmailListDto getSimilarEmails(Users validUsers) {
        this.deduplication = new Deduplication();
        for (UserInfo userInfo : validUsers.getUserInfos()) {
            addUserInfo(userInfo);

        }

        return deduplication.getRemoved();
    }

    private void addUserInfo(UserInfo userInfo) {
        List<String> tokens = new TokenGenerator(userInfo.getNickname()).getTokens();
        tokens.forEach((token) -> addToken(token, userInfo.getEmail()));
    }

    private void addToken(String token, String email) {
        if (tokenMap.has(token)) {
            deduplication.add(email);
            deduplication.add(tokenMap.get(token));
            return;
        }
        tokenMap.set(token, email);
    }
}
