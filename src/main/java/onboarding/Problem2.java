package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        //4.더 이상 제거할 문자가 없을때까지 반복하는 while문
        while(true) {
            answer = deleteSameCharacter(cryptogram);
            if(answer.equals(cryptogram)) {
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }

    private static String deleteSameCharacter(String str) {

    }
}
