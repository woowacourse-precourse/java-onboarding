package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    private static final int EMAIL_INDEX = 0;
    private static final int NICK_NAME_INDEX = 1;


    private static final Map<String, LetterNode> letterNodeMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> infos : forms) {
            String nickname = infos.get(NICK_NAME_INDEX);

            String[] letters = nickname.split("");
            LetterNode prev = null;

            for (String letter : letters) {
                LetterNode letterNode =
                    letterNodeMap.getOrDefault(letter, new LetterNode(letter));
                letterNodeMap.put(letter, letterNode);
                if (prev == null) {
                    prev = letterNode;
                    continue;
                }

                prev.addNext(letterNode);
                prev = letterNode;
            }
        }

        for (List<String> infos : forms) {
            String email = infos.get(EMAIL_INDEX);
            String nickname = infos.get(NICK_NAME_INDEX);
            String[] letters = nickname.split("");

            for (int i = 0; i < letters.length - 1; i++) {
                LetterNode primaryLetter = letterNodeMap.get(letters[i]);
                LetterNode secondaryLetter = letterNodeMap.get(letters[i + 1]);
                if (primaryLetter.isNextLetter(secondaryLetter)) {
                    answer.add(email);
                    break;
                }
            }
        }

        return answer;
    }
}

class LetterNode {
    private String letter;
    private Set<LetterNode> next = new HashSet<>();

    public LetterNode(String letter) {
        this.letter = letter;
    }

    public void addNext(LetterNode letterNode) {
        this.next.add(letterNode);
    }

    public boolean isNextLetter(LetterNode letterNode) {
        return next.contains(letterNode);
    }
    public String getLetter() {
        return letter;
    }

    public Set<LetterNode> getNext() {
        return next;
    }
}
