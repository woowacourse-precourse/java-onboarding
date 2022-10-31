package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nickname = new ArrayList<>();
        List<String> word = new ArrayList<>();
        Set<String> duplicateWord = new HashSet<>();
        Set<String> duplicateNickname = new HashSet<>();
        Set<String> duplicateEmail = new TreeSet<>();

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

        for (String str : duplicateNickname) {
            for (int i = 0; i < forms.size(); i++) {
                String name = forms.get(i).get(1);
                String email = forms.get(i).get(0);
                if (name.equals(str)) {
                    duplicateEmail.add(email);
                }
            }
        }

        return List.copyOf(duplicateEmail);
    }
}
