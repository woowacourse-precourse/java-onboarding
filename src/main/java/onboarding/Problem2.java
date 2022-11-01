package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);
        while(true){
            List<Integer> s = new ArrayList<>();
            int[] arr = new int[sb.length()];
            String str="";
            int k=0;
            if(sb.length() == 0){
                break;
            }
            for(int i=1;i<sb.length();i++){
                if(sb.charAt(i-1) == sb.charAt(i)){
                    s.add(i);
                    arr[i-1] = i;
                    k++;
                }
            }
            if(s.size()==0 || k==0){
                break;
            }

        }
        return answer;
    }
}
