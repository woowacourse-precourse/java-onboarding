package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = DeduplicationString(answer);
        return answer;
    }

    static String DeduplicationString(String s){
        String answer = s;

        while(true) {

            int startIndex = 0;
            int endIndex = 0;

            for(int i=0;i<answer.length()-1;i++) {
                if(answer.charAt(i) == answer.charAt(i+1)) {
                    startIndex = i;
                    endIndex = i+1;
                    break;
                }
            }

            if(startIndex == 0 && endIndex == 0) {
                break;
            }
            else {
                answer = answer.substring(0,startIndex)+answer.substring(endIndex+1);
            }
        }

        return answer;
    }
}
