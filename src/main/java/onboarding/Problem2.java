package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {


        String answer = cryptogram;
        String temp = "";
        int check1 = 0;
        int check2 = 0;

        while(true) {
            for(int i=0; i<answer.length(); i++) {
                if(check1==1) {
                    check1 = 0;
                    break;
                }
                if(answer.charAt(i) != answer.charAt(i+1)) {
                    temp += answer.charAt(i);
                } else {
                    check1 = 1;
                    check2 = 1;
                    break;
                }
            }
            if (check2 == 0) break;
            answer = temp;
            temp = "";
            check2 = 0;
        }

        return answer;

    }

}
