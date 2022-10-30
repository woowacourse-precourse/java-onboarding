package onboarding;

public class Problem2 {
    // idea: String -> .toChararray() 통해서 char 배열로 바꿔보자.
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String ans = "";
        int i = 0;

        int count = 0; int indexEnd = 0;
        for(i=0; i<answer.length()-1; i++){
            if(answer.charAt(i) != answer.charAt(i+1)){
                count = 0;
                continue;
            }else{
                ans = answer.substring(i) + answer.substring(i+1, answer.length()-1);
            }
        }

        return answer;
    }
}
