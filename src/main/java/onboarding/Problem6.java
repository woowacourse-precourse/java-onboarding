package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> tmp = new ArrayList<>();

        if (!isOutOfRange(forms)) {
            return new ArrayList<>();
        }

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                for (int k = 0; k < forms.get(i).get(1).length() - 1; k++) {
                    if (isContain(forms.get(j).get(1), forms.get(i).get(1).substring(k, k + 2)) && isNickNameKorean(forms.get(i).get(1))) {
                        addEmail(tmp, forms.get(j).get(0));// tmp.add(forms.get(j).get(0));
                        addEmail(tmp, forms.get(i).get(0)); // tmp.add(forms.get(i).get(0));
                    }
                }
            }
        }

        List<String> answer = deleteDuplicatedValue(tmp);

        Collections.sort(answer);

        return answer;
    }

    private static List<String> deleteDuplicatedValue(List<String> tmp) {
        Set<String> set = new HashSet<>(tmp);

        return new ArrayList<>(set);
    }

    private static boolean isOutOfRange(List<List<String>> list) {
        return list.size() >= 1 && list.size() <= 10000;
    }

    private static boolean isNickNameKorean(String nickName) {
        return nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
    }

    private static boolean isContain(String a, String b) {
        return a.contains(b);
    }

    private static void addEmail(List<String> list, String email) {
        if (isCorrectEmailDomain(email) && isCorrectEmailForm(email) && isCorrectEmailLength(email)) {
            list.add(email);
        }
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

}
