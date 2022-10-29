package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    // 1. 입력받은 문자열을 문자를 요소로하는 리스트로 변환
    static List<Character> getTransList(String cryptogram)
    {
        List<Character> TransList = new ArrayList<>();

        // 문자 하나씩 추가
        for(int idx=0; idx<cryptogram.length(); idx++)
        {
            TransList.add(cryptogram.charAt(idx));
        }

        return TransList;
    }

    // 2. 리스트 요소 중 연속되는 문자 확인
    static int getCheckList(List<Character> cryptogramList)
    {
        // 이전 문자 초기화
        char preAlpha = cryptogramList.get(0);

        for(int idx=1; idx<cryptogramList.size(); idx++)
        {
            // 이전 문자와 현 문자 비교
            if(preAlpha == cryptogramList.get(idx))
                return idx-1;

            // 이전 문자 변경
            preAlpha = cryptogramList.get(idx);
        }

        return 0;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        // 문자열 리스트화
        List<Character> cryptogramList = getTransList(cryptogram);

        // 연속되는 문자 인덱스 값 받아오기
        int listIndex = getCheckList(cryptogramList);

        // 시작 인덱스 값 결과 확인
        System.out.println("시작 인덱스 : " + listIndex);

        return answer;
    }
}

// 기능 요구 사항
// 1. 입력받은 문자열을 문자를 요소로하는 리스트로 변환
// 2. 리스트 요소 중 연속되는 문자 확인
// 3. 리스트 내 문자 제거
// 4. "browoanoommnaon" → "browoannaon" → "browoaaon" → "browoon" → "brown"

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기
