package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer str = new StringBuffer(cryptogram);
        String answer = checkOverLapByRecur(str, str.length());
        return answer;
    }
    public static String checkOverLapByRecur(StringBuffer str, int len){
        StringBuffer tempStr = str;
        for(int i=0; i<len; i++){
            if(i+1<tempStr.length()){
                if(tempStr.charAt(i) == tempStr.charAt(i+1)){
                    tempStr.deleteCharAt(i);
                    tempStr.deleteCharAt(i);
                    len -= 2;
                    if(len == 0) return "";
                    checkOverLapByRecur(tempStr,len);
                }
            }
        }
        return tempStr.toString();
    }
}
