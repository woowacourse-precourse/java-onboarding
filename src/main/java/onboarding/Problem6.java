package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    // 2. 닉네임 중복 체크
    static boolean getCheckNickName(List<String> basic, List<String> compare)
    {
        // 기존 문자열 저장
        String word = basic.get(1);

        // 두 글자씩 비교
        for(int strIdx=0; strIdx<word.length()-1; strIdx++)
        {
            String resultSubStr = word.substring(strIdx, strIdx + 2);
            // 두 글자가 비교 문자열에 포함된 경우
            if(compare.get(1).contains(resultSubStr))
                return true;
        }
        return false;
    }

    // 3. 중복 닉네임의 이메일 결과 리스트에 저장하기
    static void addResultList(List<String> resultList, String email, String compareEmail)
    {
        resultList.add(email);
        resultList.add(compareEmail);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> resultList = new ArrayList<>();

        // 1. 모든 정보 확인
        int totalSize = forms.size();

        for(int idx=0; idx<totalSize; idx++)
        {
            String email = forms.get(idx).get(0);
            String nickName = forms.get(idx).get(1);
            List<String> basic = List.of(email, nickName);

            for(int value=idx+1; value<totalSize; value++) {
                String compareEmail = forms.get(value).get(0);
                String compareNickName = forms.get(value).get(1);
                List<String> compare = List.of(compareEmail, compareNickName);

                // 닉네임 중복 체크
                boolean resultCompare = getCheckNickName(basic, compare);
                if (resultCompare == true)
                {
                    // 결과 값 결과 리스트에 저장
                    addResultList(resultList, email,compareEmail);
                    break;
                }
            }
        }
        
        // 결과를 리스트에 저장한 결과 확인
        System.out.println(resultList);

        return answer;
    }
}

// 기능 요구 사항
// 1. 모든 정보 확인
// 2. 닉네임 중복 체크
// 3. 중복 닉네임의 이메일 결과 리스트에 저장
// 4. 결과 리스트 내 정렬 & 중복 확인
// 5. 제한사항

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기