package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        ArrayList arr = new ArrayList();
        char[] chars = cryptogram.toCharArray();
        String updatedString = cryptogram;
        int check = 0;
        for (char c:chars){

            int count = cryptogram.length() - cryptogram.replace(String.valueOf(c),"").length();
            int index = updatedString.indexOf(c);

            boolean flag = true;
            // string gets shorter
            updatedString = updatedString.substring(index);
            if(count>1) {
                if(updatedString.substring(1).indexOf(c)==0){
                    flag=false;
                    check++;
                    continue;
                } else if(flag==false){
                    flag=true;
                    continue;
                } else {
                    answer+=c;
                    flag = true;
                }
            }else{
                answer+=c;
            }
        }
        if (check == 0){
            return answer;
        } else{
            cryptogram = answer;
            return solution(cryptogram);
        }
    }
}
