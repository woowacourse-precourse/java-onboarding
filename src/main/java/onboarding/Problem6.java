package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            crewNumberValidation(forms.size());

            List<String> answer = gather(forms);
            return answer;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static boolean check(List<List<String>> forms, int idx) {
        for (int i = 0; i < forms.size(); i++) {
            if (idx == i) {
                continue;
            }

            formValidation(forms.get(idx));

            String fivotName = forms.get(idx).get(1);
            String name = forms.get(i).get(1);

            for (int j = 0; j < fivotName.length() - 1; j++) {
                for (int k = 0; k < name.length() - 1; k++) {
                    if ((fivotName.charAt(j) == name.charAt(k)) && (fivotName.charAt(j + 1) == name.charAt(k + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<String> gather(List<List<String>> forms) {
        ArrayList<String> emailList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (check(forms, i)) {
                emailList.add(forms.get(i).get(0));
            }
        }

        emailList.sort(Comparator.naturalOrder());
        return emailList;
    }

    public static void crewNumberValidation(int size) {
        if (size < 1 || size > 10000) {
            throw new RuntimeException("크루는 1명 이상, 10,000 명 이하입니다.");
        }
    }

    public static void formValidation(List<String> fivot) {
        String email = fivot.get(0);
        String name = fivot.get(1);
        int emailSize = email.length();
        int nameSize = name.length();

        int idx = email.indexOf("@");
        if (!(email.substring(idx + 1).equals("email.com"))) {
            throw new RuntimeException("email.com 이메일만 사용할 수 있습니다.");
        }

        if (emailSize < 11 || emailSize > 19) {
            throw new RuntimeException("이메일 길이는 11자 이상 20자 미만입니다.");
        }

        if (nameSize < 1 || nameSize > 19) {
            throw new RuntimeException("닉네임의 길이는 1자 이상 20자 미만입니다.");
        }

        String regExp = "^[가-힣]*$";
        if (!name.matches(regExp)) {
            throw new RuntimeException("닉네임은 한글만 가능합니다.");
        }
    }
}
