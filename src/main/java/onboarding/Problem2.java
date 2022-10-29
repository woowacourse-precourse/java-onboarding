package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        for (int i=0; i<answer.length()-1; i++){
            if (answer.charAt(i) == answer.charAt(i+1)){
                answer = answer.substring(0, i) + answer.substring(i+2, answer.length());
//                System.out.println(answer);
                answer = solution(answer);
            }
        }
        return answer;
    }
}
