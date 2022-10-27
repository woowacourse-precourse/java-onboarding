package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    private static Map<String, LetterNode> letterNodeMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (List<String> infos : forms) {
            String nickname = infos.get(1);

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
    public String getLetter() {
        return letter;
    }

    public Set<LetterNode> getNext() {
        return next;
    }
}
