/*
 * 클래스명: Problem4
 *
 * 시작 날짜: 2022-10-29
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Antonym antonym = new Antonym();

        for (int i=0; i<word.length(); i++) {
            if (65 <= word.charAt(i) && word.charAt(i) <= 90) {// 대문자인 경우
                answer += antonym.antonym(word.charAt(i), 65);
                continue;
            }
            if (97 <= word.charAt(i) && word.charAt(i) <= 122){// 소문자인 경우
                answer += antonym.antonym(word.charAt(i), 97);
                continue;
            }
            answer += word.charAt(i); //대문자도 소문자도 아닌 경우
        }
        return answer;
    }
}

class Antonym{
    public char antonym(char word, int firstNumber){
        char result = ' ';
        int tmp = 25 - (word-firstNumber) * 2;
        result = (char) (word + tmp);
        return result;
    }
}