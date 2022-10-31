package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String ans="";
        ans=cryptogram;

        while(!ans.equals("")){
            int len=ans.length();
            int flag=0;
            String temp="";
            for(int i=1;i<len;i++){
                if(ans.charAt(i-1)==ans.charAt(i)){
                    flag=1;
                    i++;
                    if(i==len-1){
                        temp+=ans.charAt(i);
                    }
                    if(i==len)break;
                }else{
                    temp+=ans.charAt(i-1);
                    if(i==len-1){
                        temp+=ans.charAt(i);
                    }
                }
            }
            ans=temp;
            if(flag==0){
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args){
        String s = "browoanoommnaon";
        System.out.println(solution(s));
    }
}
