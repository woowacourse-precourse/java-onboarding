package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        User.validate(forms);
        return User.getUserDuplicatedNickName(forms);
    }
}

class User {
    private static final int LOWER_BOUND_LIMIT = 1;
    private static final int UPPER_BOUND_LIMIT = 1000000;
    private static final String OUT_OF_COUNT = "1개이상 10,000개 이하의 유저 데이터를 입력해 주세요";
    private static final String NOT_MATCH_EMAIL_PATTERN = "이메일의 형식에 맞게 입력해 주세요";


    static List<String> getUserDuplicatedNickName(List<List<String>> forms){
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size()-1; i++) {
            int cnt = 0;
            String firstUserName = forms.get(i).get(1);
            for (int j = i+1; j < forms.size(); j++) {
                String comparedUser = forms.get(j).get(1);
                if(isContains(firstUserName, comparedUser)){
                    answer.add(forms.get(j).get(0));
                    cnt++;
                }
            }
            if(cnt > 0)
                answer.add(forms.get(i).get(0));
        }
        return removeDuplicatedEmail(answer);
    }

    private static List<String> removeDuplicatedEmail(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static boolean isContains(String name1, String name2) {
        for (int i = 0; i < name1.length()-1; i++) {
        // 부분문자열 2개를 추출
            String substring = name1.substring(i, i + 2);
            if(name2.contains(substring))
                return true;
        }
        return false;
    }

    public static void validate(List<List<String>> forms) {
        validateOutOfUserCount(forms);
        validateEmailFormat(forms);
    }

    private static void validateEmailFormat(List<List<String>> forms) {
        for (List<String> emailObject : forms) {
            String userEmail = emailObject.get(0);
            if(userEmail.endsWith("@email.com"))
                continue;
            throw new IllegalArgumentException(NOT_MATCH_EMAIL_PATTERN);
        }

    }

    private static void validateOutOfUserCount(List<List<String>> forms) {
        if(forms.size() < LOWER_BOUND_LIMIT || forms.size() > UPPER_BOUND_LIMIT)
            throw new IllegalArgumentException(OUT_OF_COUNT);
    }
}