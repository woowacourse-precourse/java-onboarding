package onboarding;

import java.util.ArrayList;

public class Problem2 {

    private static String delDuplicate(String str){
        String[] strArr = str.split("");
        ArrayList<String> newArr = new ArrayList<>();

        for(int i=1;i<strArr.length;i++){
            if(strArr[i].equals(strArr[i-1])){
                strArr[i]="";
                strArr[i-1]="";
            }
        }
        return String.join("",strArr);
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        int dif = 1;
        int before, after;

        while(dif > 0){
            before = answer.length();
            System.out.println(answer);
            answer = delDuplicate(answer);
            System.out.println(answer);
            after = answer.length();

            dif = before - after;
        }

        return answer;
    }
}
