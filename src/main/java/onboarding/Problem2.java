package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String pastCryptogram = "";

        // 정규표현식 사용 -> 연속하여 중복되는 문자 제거
        while(!cryptogram.equals(pastCryptogram)){
            // 전과 후를 비교하여 제거할 중복문자가 없으면 탈출하도록 이전의 cryptogram을 저장
            pastCryptogram = cryptogram;
            cryptogram = cryptogram.replaceAll("(([a-z])\\2+)", "");
        }
        // regex 해석
        /*
            [a-z] : 소문자
            \\2 : 숫자 2를 의미
            + : 1개 이상일 때
            \\2+ : 2개 이상일 때
            (([a-z])\\2+) : 소문자가 두 개 이상일 때 해당 부분을 ""로 replace
         */

        return cryptogram;
    }
}
