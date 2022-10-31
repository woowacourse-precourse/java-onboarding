package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    static HashSet<String> result = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            findAndAddSerialNickname(forms, i);
        }
        List<String> answer = new ArrayList<>(result);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static void findAndAddSerialNickname(List<List<String>> forms, int currentUserIdx) {
        String serialChar = "";
        List<String> currentUserInfo = forms.get(currentUserIdx);
        for (int i = 0; i < forms.get(currentUserIdx).get(1).length()-1; i++) {
            serialChar = currentUserInfo.get(1).charAt(i) + String.valueOf(currentUserInfo.get(1).charAt(i+1));
            checkContainsSerialChar(serialChar, currentUserIdx, forms);
        }
    }

    public static void checkContainsSerialChar(String serialChar, int currentUserIdx, List<List<String>> forms) {
        for (int i = currentUserIdx+1; i < forms.size(); i++) {
            if (forms.get(i).get(1).contains(serialChar)) {
                result.add(forms.get(currentUserIdx).get(0));
                result.add(forms.get(i).get(0));
            }
        }
    }
}
