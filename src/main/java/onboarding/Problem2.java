package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        //알파벳 소문자가 연속되는 경우
        String pattern = "(([a-z])\\2{1,})";

        //변화가 없을 때까지 반복
        String prev = "";
        while(prev != cryptogram){
            prev = cryptogram;
            cryptogram = cryptogram.replaceAll(pattern,"");
        }

        return cryptogram;
    }
}
