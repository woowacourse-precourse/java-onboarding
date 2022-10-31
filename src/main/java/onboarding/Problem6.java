package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    /**
     * 닉네임 신청 정보를 저장하는 클래스
     */
    static class Form {
        String email;
        String name;
        boolean valid;

        public Form(String email, String name, boolean valid) {
            this.email = email;
            this.name = name;
            this.valid = valid;
        }
    }

    /**
     * 닉네임 비교 메서드
     * @param a 비교하려는 문자
     * @param b 비교하려는 문자
     * @return 같은 글자가 연속적으로 포함 될 경우 true
     */
    public static boolean compareName(String a, String b) {
        a += " ";
        b += " ";
        for (int indexA = 0; indexA < a.length()-2; indexA++) {
            for (int indexB = 0; indexB < b.length()-2; indexB++) {
                if (a.charAt(indexA) != b.charAt(indexB)) continue;
                if (a.charAt(indexA + 1) != b.charAt(indexB + 1)) continue;
                return true;
            }
        }
        return false;
    }

    /**
     * 닉네임 유효성 검증 메서드
     * @param forms 닉네임 신청 리스트
     * @return 유효하지 않은 닉네임을 작성한 지원자의 이메일 목록
     */
    public static List<String> checkValid(List<Form> forms) {
        List<String> resultList = new ArrayList<>();
        for (Form o : forms) {
            if(o.valid) continue;
            for (Form x : forms) {
                if(o.email.equals(x.email)) continue;
                if (!compareName(o.name, x.name)) continue;

                resultList.add(o.email);
                o.valid = true;

                if (!x.valid) {
                    resultList.add(x.email);
                    x.valid = true;
                }
                break;
            }
        }
        return resultList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Form> resultForm = new ArrayList<>();
        for (List<String> o : forms) {
            resultForm.add(new Form(o.get(0), o.get(1), false));
        }

        List<String> answer = checkValid(resultForm);
        Collections.sort(answer);
        return answer;
    }
}
