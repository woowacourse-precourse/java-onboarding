package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> profile = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            profile.put(forms.get(i).get(1), forms.get(i).get(0));
        }
        List<String> nicknames = new ArrayList<>(profile.keySet());
        List<List<String>> duplicateNicknames = new ArrayList<>();
        for (int i = 0; i < nicknames.size(); i++) {
            List<String> twoLetters = splitToTwoLetters(nicknames.get(i));
            for (int j = 0; j < twoLetters.size(); j++) {
                duplicateNicknames.add(findDuplicate(nicknames, twoLetters.get(j), i));
            }
        }

        return emails;
    }
    public static List<String> splitToTwoLetters(String nickname){
        List<String> nicknameTwoLetters = new ArrayList<>();
        for (int i = 0; i < nickname.length()-1; i++) {
            String twoLetter = nickname.substring(i,i+2);
            nicknameTwoLetters.add(twoLetter);
        }
        return nicknameTwoLetters;
    }
    public static List<String> findDuplicate(List<String> nicknames, String twoLetter, int selfNumber){
        List<String> duplicateNicknames = new ArrayList<>();
        for (int i = 0; i < nicknames.size(); i++) {
            if (i != selfNumber && nicknames.get(i).contains(twoLetter)) {
                duplicateNicknames.add(nicknames.get(i));
            }
        }
        return duplicateNicknames;
    }
}
