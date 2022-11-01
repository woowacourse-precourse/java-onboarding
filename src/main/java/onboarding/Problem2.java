package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String answer2 = "";

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};

        // answer2에다가 기존 answer 값을 미리 넣고 answer 값은 중복 문자들을 ""값으로 모두 치환하고
        // 바뀐 answer 값과 기존 answer 값인 answer2값을 비교해서 변화가 없으면 종료 아니면 계속 실행
        while (!answer2.equals(answer)) {
            answer2 = answer;
            for (char c : alphabet) {
                answer = answer.replaceAll(String.format("%c" + "{2,}", c), "");
            }
        }
        return answer;
    }
}
