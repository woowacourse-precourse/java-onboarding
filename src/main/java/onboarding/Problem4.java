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
                // 대문자 변환
                if(alpha >='A' && alpha <= 'Z')
                    alpha = getTransAlpha(alpha, 65);

                // 소문자 변환
                else if(alpha >= 'a' && alpha <= 'z')
                    alpha = getTransAlpha(alpha, 97);

                // 3-2. 알파벳 변환하기 ( 적용 )
                wordList.set(idx,alpha);
            }
        }
    }

    // 3-1. 알파벳 변환하기 ( 변환 )
    static char getTransAlpha(char alpha, int number)
    {
        // 문자 변환
        alpha = (char)(number - (int)alpha + 25 + number);

        return alpha;
    }

    // 4. 문자 단위 리스트를 문자열로 변환하기
    static String getTransStr(List<Character> wordList)
    {
        String temp = "";

        for(Character value : wordList)
            temp += value;

        return temp;
    }

    public static String solution(String word) {
        String answer = "";

        // 제한사항
        if(word.length() < 1 || word.length() > 1000)
        {
            answer = "문자열 길이 제한";
            return answer;
        }

        // 문자열 리스트화
        List<Character> wordList = getTransList(word);

        // 문자 확인
        getCheckAlpha(wordList);

        // 변환 결과 문자열화
        answer = getTransStr(wordList);

        return answer;
    }
}

// 기능 요구 사항
// ✔ 1. 엄마 말씀을 문자 단위 리스트화
// ✔ 2. 각 문자 정보 확인
// ✔ 3. 알파벳 변환하기 ( 제한사항 생각 )
// ✔ 4. 문자 단위 리스트를 문자열로 변환

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// ✔ 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// ✔ 3. 프로그램 종료 시 "System.exit()"를 호출 X
// ✔ 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// ✔ 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기