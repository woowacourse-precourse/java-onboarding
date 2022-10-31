package onboarding.problem6;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Crew {
    private static final int SNIPPET_LENGTH=2;

    private String nickname;
    private String email;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public boolean isPossibleToMakeSnippets() {
        return nickname.length() > 1;
    }

    public ArrayList<String> nicknameToSnippets() {
        int nicknameLen = this.nickname.length();
        ArrayList<String> snippets = new ArrayList<>();

        IntStream.rangeClosed(0, nicknameLen - SNIPPET_LENGTH)
                .forEach((startIndex) -> {
                    snippets.add(nickname.substring(startIndex, startIndex + SNIPPET_LENGTH));
                });

        return snippets;
    }

    public String getEmail() {
        return this.email;
    }
}
