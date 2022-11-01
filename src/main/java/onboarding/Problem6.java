package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> splitNickName(String nickname) {
        List<String> nicknameSet = new ArrayList<String>();
        for(int i = 0; i < nickname.length()-1; i++) {
            String nicknameElement = "";
            nicknameElement += nickname.charAt(i);
            nicknameElement += nickname.charAt(i+1);
            nicknameSet.add(nicknameElement);
        }
        return nicknameSet;
    }

    public static boolean compareElement (List<String> nicknameSet, String nickname) {
        for (String nicknameElement: nicknameSet) {
            if (nickname.contains(nicknameElement)) return true;
        }
        return false;
    }

    public static List<String> addEmail(List<List<String>> forms) {
        List<String> correctEmail = new ArrayList<>();
        for (int j = 0; j < forms.size()-1; j++) {
            int prevention = 0;
            for (int k = j + 1; k < forms.size(); k++) {
                if (prevention < 1 && compareElement(splitNickName(forms.get(j).get(1)), forms.get(k).get(1))) {
                    correctEmail.add(forms.get(j).get(0));
                    prevention += 1;
                }
                if (compareElement(splitNickName(forms.get(j).get(1)), forms.get(k).get(1))) {
                    correctEmail.add(forms.get(k).get(0));
                }
            }
        }
        return correctEmail;
    }

    public static List<String> removeDuplicate (List<String> correctEmail) {
        List<String> answerEmail = correctEmail.stream().distinct().collect(Collectors.toList());
        Collections.sort(answerEmail);
        return answerEmail;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answerEmail = addEmail(forms);
        answerEmail = removeDuplicate(answerEmail);
        return answerEmail;
    }
}
