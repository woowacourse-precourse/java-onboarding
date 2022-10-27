package onboarding;

// 길이가 1 이상 1000 이하인 문자열을 받는다.
// 알파벳 외의 문자는 변환하지 않고, 대문자는 대문자로 소문자는 소문자로 변환한다.
// 문자열의 각 문자를 a -> z로, b -> y로, ... , Z -> A로 변환 후 반환

// todo
// 1. 각 문자를 변환하는 과정에서 규칙성 찾아보기
// 1-2. 문자를 숫자로 변환해보기
// 1-3. 숫자를 문자로 변환해보기
// 2. 발견한 규칙((첫문자+끝문자)-해당문자)을 바탕으로 소문자, 대문자, 공백일때의 상황으로 분류해 조건 설정하기

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // A = 65
        // Z = 90
        // a = 97
        // z = 122

//        for (int i = 0; i < word.length(); i++) {
//
//            answer += word.charAt(i);
//        }

        int testNum = 100;
        char testChar = (char) testNum;

        System.out.println(testChar);

        return answer;
    }
}
