package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> nickname = new HashSet<>();
        ArrayList<String> word = new ArrayList<>();
        Set<String> duplicateWord = new HashSet<>();
        HashSet<String> duplicateNickname = new HashSet<>();

        for (List<String> form : forms) {
            nickname.add(form.get(1));
            for (int i = 1; i < form.get(1).length(); i++) {
                word.add(form.get(1).substring(i - 1, i + 1));
            }
        }

        for (String str : word) {
            if (word.indexOf(str) != word.lastIndexOf(str)) {
                duplicateWord.add(str);
            }
        }

        for (String str : duplicateWord) {
            for (String name : nickname) {
                if (name.contains(str)) {
                    duplicateNickname.add(name);
                }
            }
        }

        return answer;
    }
}
