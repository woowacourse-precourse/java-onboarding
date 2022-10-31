package onboarding;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - word는 길이가 1 이상 1,000 이하인 문자열이다.
 * - 알파벳 외의 문자는 변환하지 않는다.
 * - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 *
 * 1. 접근 방식
 * - 문자를 문제에서 요구하는 방식으로 바꾸는 convertLetter() 메소드를 사용
 *  _ 대문자와 소문자 method를 나눠 구현
 *
 * 2. 문자 교체 방식
 * - ASCII CODE를 사용하여 접근
 *   _ A : 65 ~ Z : 90 || a : 97 ~ z : 122
 *   _ M(77)을 기준으로 작거나 같으면 +를, 크면 -를 해준다.
 *
 * */
public class Problem4 {
    public static String solution(String word) {
        Problem4 problem4 = new Problem4();
        char[] wordCharArray = word.toCharArray();
        String answer = "";

        // wordCharArray를 순회하면서 각각의 char letter를 변환
        for (char letter : wordCharArray) {
            // 알파벳 문자가 아닌 경우 변환하지 않는다.
            if (!problem4.isAlphabet(letter)){
                answer += String.valueOf(letter);
                continue;
            }

            if(Character.isUpperCase(letter)){      // 대문자의 경우 convertUpperLetter 호출
                answer += String.valueOf(problem4.convertUpperLetter(letter));
            } else if(Character.isLowerCase(letter)){   // 소문자의 경우 convertLowerLetter 호출
                answer += String.valueOf(problem4.convertLowerLetter(letter));
            }
        }

        return answer;
    }

    // 문자가 알파벳인지 확인
    public boolean isAlphabet(char letter){
        if (!(((int)letter >= 65 && (int)letter <= 90) || ((int)letter >= 97 && (int)letter <= 122))){
            return false;
        }

        return true;
    }

    // 대문자 char형 letter를 M(77)을 기준 변환
    public char convertUpperLetter(char letter){
        int letterAscii = letter;

        // M(77)을 기준으로 작거나 같으면 +를, 크면 -를 해준다.
        if(letterAscii <= 77){
            letterAscii = (78 - letterAscii) + 77;
        }else{
            letterAscii = 77 - (letterAscii - 78);
        }

        return (char)letterAscii;
    }

    // 소문자 char형 letter를 m(109)을 기준 변환
    public char convertLowerLetter(char letter){
        int letterAscii = letter;

        // m(109)을 기준으로 작거나 같으면 +를, 크면 -를 해준다.
        if(letterAscii <= 109){
            letterAscii = (110 - letterAscii) + 109;
        }else{
            letterAscii = 109 - (letterAscii - 110);
        }

        return (char)letterAscii;
    }

}
