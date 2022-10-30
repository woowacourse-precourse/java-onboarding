package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 구현 기능 목록
 * 1. 닉네임을 두글자씩 쪼개어 리스트로 저장
 * 2. 쪼갠 닉네임과 이메일을 해시맵으로 저장
 * 3. 쪼갠 닉네임을 통해 연속으로 두글자 이상 중복된 닉네임을 가진 사람 찾기
 * 4. 중복 닉네임을 가진 사람의 이메일을 정렬하여 반환
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> splitNickname(String nickname) {
        List<String> nicknameParts = new ArrayList<>();
        for (int i=0; i < nickname.length()-1; i++) {
            nicknameParts.add(nickname.substring(i, i+2));
        }
        return nicknameParts;
    }

    private static HashMap<String, List<String>> matchEmailAndNicknameParts(List<List<String>> forms) {
        HashMap<String, List<String>> emailAndNicknameParts = new HashMap<>();
        for (int i=0; i < forms.size(); i++) {
            List<String> nicknameParts = splitNickname(forms.get(i).get(1));
            emailAndNicknameParts.put(forms.get(i).get(0), nicknameParts);
        }
        return emailAndNicknameParts;
    }
}
