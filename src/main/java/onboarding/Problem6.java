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

        List<Person> people = new ArrayList<>();

        for (List<String> infos : forms) {
            String nickname = infos.get(NICK_NAME_INDEX);
            String email = infos.get(EMAIL_INDEX);
            people.add(new Person(email, nickname));
        }
        for (Person person : people) {
            String nickname = person.getNickname();

            String[] letters = nickname.split("");
            LetterNode prev = null;

            for (String letter : letters) {
                LetterNode letterNode =
                    letterNodeMap.getOrDefault(letter, new LetterNode(letter));
                letterNode.addOwner(person);
                letterNodeMap.put(letter, letterNode);
                if (prev == null) {
                    prev = letterNode;
                    continue;
                }

                prev.addNext(letterNode);
                prev = letterNode;
            }
        }

        for (Person person : people) {
            String email = person.getEmail();
            String nickname = person.getNickname();
            String[] letters = nickname.split("");

            for (int i = 0; i < letters.length - 1; i++) {
                LetterNode primaryLetter = letterNodeMap.get(letters[i]);
                LetterNode secondaryLetter = letterNodeMap.get(letters[i + 1]);
                if (primaryLetter.isNextLetter(secondaryLetter)
                    && !primaryLetter.isOnlyOwner(person)
                    && !secondaryLetter.isOnlyOwner(person)) {
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
    private Set<Person> letterOwners = new HashSet<>();


    public LetterNode(String letter) {
        this.letter = letter;
    }

    public void addNext(LetterNode letterNode) {
        this.next.add(letterNode);
    }

    public boolean isNextLetter(LetterNode letterNode) {
        return next.contains(letterNode);
    }

    public void addOwner(Person person) {
        this.letterOwners.add(person);
    }

    public boolean isOnlyOwner(Person person) {
        if (letterOwners.size() == 1 && letterOwners.contains(person)) {
            return true;
        }
        return false;
    }
    public String getLetter() {
        return letter;
    }

    public Set<LetterNode> getNext() {
        return next;
    }
}

class Person {
    private String email;
    private String nickname;

    public Person(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
