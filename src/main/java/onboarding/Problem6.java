package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    /**
     * 기능 구현
     * 1. 제한사항의 이메일, 닉네임 검사
     * 2. 닉네임 중복을 검사하는 메서드 생성
     * 3. 닉네임 중복된 사용자의 이메일을 찾는 코드
     * 4. 중복과 순서 정렬
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 1.
        List<List<String>> newForms = checkForms(forms);

        return answer;
    }

    public static List<List<String>> checkForms(List<List<String>> forms) {
        List<List<String>> newForms = new ArrayList<List<String>>();

        boolean flag = true;

        for (List<String> form : forms) {
            // 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
            if (form.get(0).matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) {
                // 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
                int idx = form.get(0).indexOf("@");
                if (!form.get(0).substring(idx + 1).matches("email.com"))
                    flag = false;
            } else {
                flag = false;
            }
            if (form.get(0).length() < 11 || form.get(0).length() > 20) flag = false;
            // 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
            if (!form.get(1).matches("^[가-힣]*$")) flag = false;
            if (form.get(1).length() < 1 || form.get(1).length() > 20) flag = false;

            if (flag) {
                newForms.add(form);
            }
        }

        return newForms;
    }

    public static boolean checkDuplicatedName(String nick, String checkNick) {

        for(int i = 0; i < nick.length()-1; i++){
            String subNick = nick.substring(i, i+2);
            for(int j = 0; j < checkNick.length()-1; j++){
                if(subNick.equals(checkNick.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
