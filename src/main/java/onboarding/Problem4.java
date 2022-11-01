package onboarding;
import java.util.HashMap;
public class Problem4 {
    public static String solution(String word) {
        String a="";
        for(int i=0;i<word.length();i++){
            int num =(int)word.charAt(i);

            if(65<=num && num<=90){
                if(num+25>90){
                    num=90-(num+25-90);
                }else{
                    num=num+25;
                }
            }else{
            if(num+25>122){
                num=122-(num+25-122);
            }else{
                num=num+25;
            }
            }
            if(num=='9'){
                a+=" ";
            }
            else {
                a+=(char)num;
            }
            System.out.println((char)num);
        }
        String answer = "";
        return a;
    }
}
