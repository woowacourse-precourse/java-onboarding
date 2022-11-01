package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    static List<String> nickList = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedUserEmail(forms);
        return answer;
    }

    public static List<String> getDuplicatedUserEmail(List<List<String>> forms) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (isUserNameDuplicated(forms.get(i))) {
                res.add(forms.get(i).get(0));
            }
        }

        nickList.remove(0);
        for (int i = 0; i < nickList.size(); i++) {
            if (isUserNameDup(forms.get(0).get(1))) {
                res.add(forms.get(0).get(0));
                break;
            }
        }

        Collections.sort(res);

        return res;
    }

    public static boolean isUserNameDuplicated(List<String> user) {
        //  이메일, 닉네임 제한사항 체크
        if (!isEmailViable(user.get(0)) || !isUserNameViable(user.get(1))) {
            return false;
        }

        if (isUserNameDup(user.get(1))) {
            return true;
        }

        return false;
    }

    public static boolean isEmailViable(String email) {
        if (11 > email.length() || email.length() >= 20) {
            return false;
        }

        if (!email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$")) {
            return false;
        }

        return true;
    }

    public static boolean isUserNameViable(String userName) {
        if (0 == userName.length() || userName.length() >= 20) {
            return false;
        }

        if (!userName.matches(".*[ㄱ-ㅎ ㅏ-ㅣ 가-힣]+.*")) {
            return false;
        }

        return true;
    }

    public static boolean isUserNameDup(String userName) {
        if (nickList.isEmpty()) {
            nickList.add(userName);
            return false;
        }

        for (int i = 0; i < nickList.size(); i++) {
            for (int j = 0; j < nickList.get(i).length() - 1; j++) {
                String regex = nickList.get(i).substring(j, j+2);
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(userName);
                while (m.find()) {
                    nickList.add(userName);
                    return true;
                }
            }
        }

        nickList.add(userName);
        return false;
    }
}
