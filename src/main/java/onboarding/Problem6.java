/**
 * 클래스 이름
 * - 문제 6
 *
 * 버전정보
 * - openjdk version "11.0.15"
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

        HashMap<String, Integer> nickNameCheck = new HashMap<String, Integer>();

        for (List<String> form : forms) {
            String nickName = form.get(1);
            nickNameCheckSet(nickNameCheck, nickName);
        }

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            if (overlapCheck(nickNameCheck, nickName)) {
                answer.add(email);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    private static boolean overlapCheck(HashMap<String, Integer> nickNameCheck, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String substring = nickName.substring(i, i + 2);

            if(nickNameCheck.get(substring)==null) continue;

            if (nickNameCheck.get(substring) > 1) {
                return true;
            }
        }
        return false;
    }

    private static void nickNameCheckSet(HashMap<String, Integer> nickNameCheck, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String substring = nickName.substring(i, i + 2);

            if (nickNameCheck.get(substring) == null) {
                nickNameCheck.put(substring, 1);
            } else{
                nickNameCheck.put(substring, nickNameCheck.get(substring) + 1);
            }
        }
    }
}


