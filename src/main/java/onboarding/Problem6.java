package onboarding;

import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    private static HashMap<String, Integer> nicknameMap = new HashMap<>();
    private static TreeSet<String> alertList = new TreeSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches() && email.length() >= 11 && email.length() <= 20) {
            return true;
        }
        return false;
    }

    public static void getNickname(String nickname, int idx, List<List<String>> forms) {
        for (int i = 0; i < nickname.length() - 1; i++){
            char nicknameChar1 = nickname.charAt(i);
            char nicknameChar2 = nickname.charAt(i + 1);

            String words = String.valueOf(nicknameChar1) + String.valueOf(nicknameChar2);
            if (nicknameMap.containsKey(words) == false) {
                nicknameMap.put(words, idx);
                continue;
            }
            int overlapIdx = nicknameMap.get(words);
            putAlertList(overlapIdx, forms);
            putAlertList(idx, forms);
        }
    }


    public static void putAlertList(int index, List<List<String>> forms) {
        List<String> userInfo = forms.get(index);
        String email = userInfo.get(0);
        alertList.add(email);
    }
}
