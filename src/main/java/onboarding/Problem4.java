package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    // 1. 입력받은 문자열을 문자를 요소로하는 리스트로 변환
    static List<Character> getTransList(String word)
    {
        List<Character> TransList = new ArrayList<>();

        // 문자 하나씩 추가
        for(int idx=0; idx<word.length(); idx++)
        {
            TransList.add(word.charAt(idx));
        }

        return TransList;
    }

    // 2. 각 문자 정보 확인
    static void getCheckAlpha(List<Character> wordList)
    {
        for(int idx=0; idx<wordList.size(); idx++)
        {
            // 각 문자를 저장
            char alpha = wordList.get(idx);
            
            // 문자가 알파벳인지 확인
            if(alpha >='A' && alpha <= 'Z' || alpha >= 'a' && alpha <= 'z' )
            {
                // 결과 확인
                System.out.println(alpha);
            }
        }
    }

    public static String solution(String word) {
        String answer = "";

        // 문자열 리스트화
        List<Character> wordList = getTransList(word);

        // 문자 확인
        getCheckAlpha(wordList);

        return answer;
    }
}

// 기능 요구 사항
// 1. 엄마 말씀을 문자 단위 리스트화
// 2. 각 문자 정보 확인
// 3. 알파벳 변환하기 ( 제한사항 생각 )
// 4. 문자 단위 리스트를 문자열로 변환

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기