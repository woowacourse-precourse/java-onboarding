package onboarding;


import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean[] eraser = new boolean[1010];
        boolean flag = true;
        String answer = cryptogram;

        while(flag){
            int stringSize = answer.length();
            String temp = "";

            for(int i=0; i<stringSize; ++i)
                if(eraser[i] == false) temp += answer.charAt(i);
            answer = temp;
            if(answer.isEmpty()) break;

            Arrays.fill(eraser, false);
            char preString = answer.charAt(0);
            flag = false;
            stringSize = answer.length();
            for(int i=1; i<stringSize; ++i){
                if(Character.compare(preString, answer.charAt(i)) == 0){
                    eraser[i-1] = true;
                    eraser[i] = true;
                    flag = true;
                }
                preString=answer.charAt(i);
            }

        }

        return answer;
    }
}
