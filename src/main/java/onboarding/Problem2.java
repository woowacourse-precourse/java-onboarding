package onboarding;

public class Problem2 {
    // 뭔가 정규표현식으로 연속된 문자 제거하는 방식으로 풀면 될듯하다

    public static String isContinue() {
        String findContinue = "\"";
        for(int i = 97; i <= 122; i++) {
            findContinue  +=  Character.toString((char) i) + "{2, }";
            if(i<122) findContinue += "|";
            else findContinue += "\"";
        }
        System.out.println(findContinue);
        return findContinue;
    }

    public static String solution(String cryptogram) {
        while(cryptogram.matches(isContinue())) {
            cryptogram.replaceAll(isContinue(), "");
        }
        return cryptogram;
    }
}
