package onboarding;

/**
 * [기능 목록]
 * 1. 알파벳 뒤집는 기능
 * - 알파벳 대문자는 대문자로, 소문자는 소문자로
 * 2. 결과 출력 기능
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int num = 0;
        int abs = 0;
        int trans = 0;
        // 문자열 자르기
        char[] ch = word.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isUpperCase(ch[i])){ // 대문자(A:65~)
                num = 65;
            }else if(Character.isLowerCase(ch[i])){ // 소문자(a:97~)
                num = 97;
            }else{ // 숫자
                answer += ' ';
                continue;
            }

            abs = Math.abs(num - ch[i]); // 절대값

            /**
             * 1. 알파벳 뒤집는 기능
             * trans = (소/대문제 알파벳 시작 부분) + (알파벳 개수) - (a/A부터 얼마나 떨어져 있는 지)
             */
            trans = num + 25 - abs;

            // 2. 결과 출력 기능
            answer += String.valueOf((char) trans);
        }
        //System.out.println("answer: " + answer);
        return answer;
    }
/*
    public static void main(String[] args) { // TEST
        String s = "I love you";

        solution(s);
    }

 */
}
