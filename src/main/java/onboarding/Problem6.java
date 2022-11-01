/**
 * 클래스 이름
 * - 문제 6
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 닉네임 중복 체크 맵
        HashMap<String, Integer> duplicationCheck = new HashMap<String, Integer>();

        for (List<String> form : forms) {
            String nickName = form.get(1);

            // 중복인지 확인하기 위한 세팅
            setDuplicationCheck(duplicationCheck, nickName);
        }

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            // 중복 확인
            if (checkDuplication(duplicationCheck, nickName)) {
                answer.add(email);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    private static boolean checkDuplication(HashMap<String, Integer> duplicationCheck, String nickName) {

        // 닉네임으로 만들 수 있는 연속적인 두 문자를 전부 만들어서 확인 -> 2이상이면 중복
        for (int i = 0; i < nickName.length() - 1; i++) {
            String substring = nickName.substring(i, i + 2);

            if(duplicationCheck.get(substring)==null) continue;

            if (duplicationCheck.get(substring) > 1) {
                return true;
            }
        }
        return false;
    }


    private static void setDuplicationCheck(HashMap<String, Integer> duplicationCheck, String nickName) {

        // 닉네임으로 만들 수 있는 연속적인 두 문자를 전부 만들어서 중복체크 맵에 카운트
        for (int i = 0; i < nickName.length() - 1; i++) {
            String substring = nickName.substring(i, i + 2);

            if (duplicationCheck.get(substring) == null) {
                duplicationCheck.put(substring, 1);
            } else{
                duplicationCheck.put(substring, duplicationCheck.get(substring) + 1);
            }
        }
    }
}


