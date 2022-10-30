package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) { List<String> tmp = new ArrayList<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                for (int k = 0; k < forms.get(i).get(1).length() - 1; k++) {
                    if (forms.get(j).get(1).contains(forms.get(i).get(1).substring(k, k + 2))) { //(check(forms.get(j).get(1), forms.get(i).get(1).substring(k, k + 2)))
                        tmp.add(forms.get(j).get(0));
                        tmp.add(forms.get(i).get(0));
                    }
                }
            }
        }

        Set<String> set = new HashSet<>(tmp);

        List<String> answer = new ArrayList<>(set);

        Collections.sort(answer);

        return answer;
    }

    private static boolean isOutOfRange(List<List<String>> list) {
        return list.size() >= 1 && list.size() <= 10000;
    }

    private static boolean isCorrectEmailLength(String email) {
        return email.length() >= 11 && email.length() <= 20;
    }

    private static boolean isCorrectEmailForm(String email) {
        String regx = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isCorrectEmailDomain(String email) {
        return email.substring(email.length() - 9).contains("email.com");
    }

    private static boolean isNickNameKorean(String nickName){
        return nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
    }
}
