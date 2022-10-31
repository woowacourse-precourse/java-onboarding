package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            char divideWord = word.charAt(i);
            int a = 25;    // a가 25, d가 -2인 등차수열로 풀어보자
            if (divideWord >= 65 && divideWord <= 90) {
                // 해당 문자가 대문자라면
                for(char c='A'; c<='Z'; c++) {
                    if (divideWord == c) break;
                    a -= 2;
                }
            } else if (divideWord >= 97 && divideWord <= 122){
                // 해당 문자가 소문자라면
                for(char c='a'; c<='z'; c++) {
                    if (divideWord == c) break;
                    a -= 2;
                }
            } else {
                answer += divideWord;
                continue;
            }

            divideWord += a;
            answer += divideWord;
        }

        return answer;
    }
}