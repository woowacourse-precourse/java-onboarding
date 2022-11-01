package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 * # 기능 정리
 * [O] 문자열 비교 메서드
 * [O] 결과 리스트 정렬
 * [O] 결과 리스트 중복 제거
 * [O] solution 작성
 * [O] 테스트 확인
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findEmailsWithDuplicateNickname(forms);
        Collections.sort(answer);
        return answer;
    }

    // 전략 -> 각 닉네임을 두글자씩 조회해서 Map에서 이전에 있었는지 조회, 조회된 경우 처음에 추가된 이메일과, 비교된 이메일 결과에 추가
    private static List<String> findEmailsWithDuplicateNickname(final List<List<String>> forms){
        HashSet<String> resultList = new HashSet<>();
        Map<String, String> checkSubstrMap = new HashMap<>();
        Map<String, String> firstAddedSubstrOriginEmailMap = new HashMap<>();

        for(int i = 0; i < forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if(nickname.length() > 1){
                for(int startIdx = 0; startIdx < nickname.length() - 1; startIdx++){
                    int endIdx = startIdx + 2;
                    String substr = nickname.substring(startIdx, endIdx);

                    if(checkSubstrMap.get(substr) == null){
                        checkSubstrMap.put(substr, email);
                        firstAddedSubstrOriginEmailMap.put(substr, email);
                        continue;
                    }

                    String originEmail = firstAddedSubstrOriginEmailMap.get(substr);

                    if(originEmail != email) {
                        resultList.add(email);
                        resultList.add(originEmail);
                    }
                }
            }
        }

        return new ArrayList<>(resultList);
    }
}
