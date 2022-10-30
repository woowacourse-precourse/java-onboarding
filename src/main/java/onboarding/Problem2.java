package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 1. 암호문을 한 글자별로 차례대로 확인
        // 2. 중복 문자가 아니라고 판단되는 문자들은 String originalText = ""에 저장
        // 중복 문자가 존재한다고 나오지 않을 때까지 위의 과정을 반복

        // 중복 문자가 아니라고 판단하는 기준
        // 1. 앞 문자가 뒷 문자와 같지 않을 경우 originalText에 저장
        // 2. 두 문자가 같았을 경우 두 개 전부 originalText에 저장하지 않으며, 뒷 문자는 그 후의 문자와도 비교해야 하기 때문에 따로 저장을 하는 부분이 필요함

        return answer;
    }

}
