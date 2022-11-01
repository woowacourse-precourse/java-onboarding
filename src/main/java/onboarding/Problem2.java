package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = checkString(cryptogram);
        return answer;
    }

    public static String comString(List<String> strList){
        String result="";
        for (String text:
             strList) {
            result+=text;
        }
        return result;
    }
    public static String checkString(String crypto) {
        String plain = "";
        String[] strArr = crypto.split(""); //Splitting string into individual characters
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        int cnt=0;
        //HashSet<String> hs = new HashSet<>();
        while (true) {
            int i=0;
            int listSize=strList.size();
            for (i = 0; i < listSize-1; i++) {
                if (strList.get(i).equals(strList.get(i+1))) {
                    strList.remove(i+1);
                    strList.remove(i);
                    break;
                }
            }
            if(listSize-1==i||listSize==0){
                break;
            }
        }
        plain = comString(strList);
        return plain;
    }
}
