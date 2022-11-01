package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer str = new StringBuffer();
        str.append(cryptogram);
        // String to Array
        char[] chararr = new char[cryptogram.length()];

        for (int i = 0; i < str.length(); i++){
            if(str.length()==0){
                return "";
            }
            
            if ((i+1) < str.length()){
                if (str.charAt(i) == str.charAt(i+1)){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    //length -= 2;
                    solution(str.toString());
                    //chararr[i] = str.charAt(i);
                    //i+=2;
                    //solution(chararr.toString());
                }
                /*
                else{
                    chararr[i] = str.charAt(i);
                    i++;
                }
                 */
            }

        }

        
        return answer;
    }
}
