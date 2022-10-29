package onboarding;

import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, Integer> nicknameMap = new HashMap<>();
        TreeSet<String> alertList = new TreeSet<>();
        for(int i = 0; i < forms.size(); i++) {
            List<String> user = forms.get(i);
            String email = user.get(0);
            String nickname = user.get(1);

            if(!checkEmail(email)) {
                continue;
            }
            getNickname(nickname, i, forms, nicknameMap, alertList);
        }

        answer = Lists.newArrayList(alertList);
        return answer;
    }

    public static boolean checkEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches() && email.length() >= 11 && email.length() <= 20;
    }

    public static void getNickname(String nickname, int idx, List<List<String>> forms, HashMap<String, Integer> nicknameMap, TreeSet<String> alertList) {
        for (int i = 0; i < nickname.length() - 1; i++){
            char nicknameChar1 = nickname.charAt(i);
            char nicknameChar2 = nickname.charAt(i + 1);

            String words = String.valueOf(nicknameChar1) + String.valueOf(nicknameChar2);
            if (!nicknameMap.containsKey(words)) {
                nicknameMap.put(words, idx);
                continue;
            }
            int overlapIdx = nicknameMap.get(words);
            putAlertList(overlapIdx, forms, alertList);
            putAlertList(idx, forms, alertList);
        }
    }


    public static void putAlertList(int index, List<List<String>> forms, TreeSet<String> alertList) {
        List<String> userInfo = forms.get(index);
        String email = userInfo.get(0);
        alertList.add(email);
    }
}
