package onboarding;

// <기능 목록>
// 1. 글자 변환하기
//  a. 알파벳 외의 문자는 변환하지 않음
//  b. 대문자와 소문자 구분
//  c. 글자 변환

public class Problem4 {
    public static String solution(String word) {
        String answer = conversionWord(word);
        return answer;
    }

    // 1. 글자 변환하기
    public static String conversionWord(String word) {
        String uppercase = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowercase = "zyxwvutsrqponmlkjihgfedcba";

        // 문자 변환하기 편하게 chararray로 변환해줌
        char[] cWord = word.toCharArray();

        // 1-a. 알파벳 외의 문자는 변환하지 않음
        // 1-b. 대문자와 소문자 구분
        // 1-c. 글자 변환
        for (int i = 0; i < cWord.length; i++) {
            if (cWord[i] >= 'A' && cWord[i] <= 'Z') {
                cWord[i] = uppercase.charAt(cWord[i] - 'A');
            } else if (cWord[i] >= 'a' && cWord[i] <= 'z') {
                cWord[i] = lowercase.charAt(cWord[i] - 'a');
            }
        }

        word = String.valueOf(cWord);
        return word;
    }
}
