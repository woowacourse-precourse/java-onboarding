package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;



    public static List<String> solution(List<List<String>> forms) {

        final Set<Crew> crews = new HashSet<>();
        final Map<String, Set<Crew>> twoSizeWordOwnerMap = new HashMap<>();

        Set<Crew> duplicatedCrewSet = new HashSet<>();
        List<String> answer = new ArrayList<>();


        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String nickname = form.get(NICKNAME_INDEX);

            Crew crew = new Crew(email, nickname);
            crews.add(crew);
        }

        for (Crew crew : crews) {
            Set<TwoSizeWord> crewTwoSizeWordSet = crew.getTwoSizeWordSet();
            for (TwoSizeWord twoSizeWord : crewTwoSizeWordSet) {
                String keyWord = twoSizeWord.getWord();
                twoSizeWordOwnerMap.computeIfAbsent(keyWord, k -> new HashSet<>());
                twoSizeWordOwnerMap.get(keyWord).add(crew);
            }
        }

        for (Set<Crew> OwnerCrewSet : twoSizeWordOwnerMap.values()) {
            if (OwnerCrewSet.size() == 1) {
                continue;
            }

            duplicatedCrewSet.addAll(OwnerCrewSet);
        }

        answer = duplicatedCrewSet.stream()
            .map(Crew::getEmail)
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        return answer;
    }
}

class TwoSizeWord {
    private String word;

    public TwoSizeWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}

class Crew {
    private String email;
    private String nickname;

    private Set<TwoSizeWord> twoSizeWordSet;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
        this.twoSizeWordSet = splitToTwoSizeWord(nickname);
    }

    private Set<TwoSizeWord> splitToTwoSizeWord(String nickname) {
        Set<TwoSizeWord> twoSizeWordSet = new HashSet<>();
        String[] split = nickname.split("");

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            word.append(split[i]);

            if (word.length() == 2) {
                TwoSizeWord twoSizeWord = new TwoSizeWord(word.toString());
                twoSizeWordSet.add(twoSizeWord);

                word.deleteCharAt(0);
            }
        }

        return twoSizeWordSet;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public Set<TwoSizeWord> getTwoSizeWordSet() {
        return twoSizeWordSet;
    }
}