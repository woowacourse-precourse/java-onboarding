package onboarding;

import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        boolean flag = true;
        int count = 0;

        while(flag==true){
            int num[] = new int [cryptogram.length()];
            flag = false;

            for(int i=0; i<cryptogram.length()-1; i++){
                if((cryptogram.charAt(i)==cryptogram.charAt(i+1))){
                    num[i]++;
                    num[i+1]++;
                    flag = true;
                }
            }
            for(int i=0; i<cryptogram.length(); i++){
                if(num[i]==0) answer+=cryptogram.charAt(i);
            }

            cryptogram = answer.substring(0,answer.length());
            answer = "";
            System.out.println(cryptogram);
        }

        return answer;
    }

    public static void main (String [] args) {

        String cryptogram = "browoanoommnaon";

        Problem2 prob = new Problem2();
        System.out.println(prob.solution(cryptogram));
    }

}
