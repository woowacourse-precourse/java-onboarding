package onboarding;

public class Problem2 {

    public static String slicing(String str){
        for(int i=1;i<str.length();i++){
            char tmp=str.charAt(i-1);
            if(tmp==str.charAt(i)){
                String s1=str.substring(0,i-1);
                String s2=str.substring(i+1,str.length());
                return s1+s2;
            }
        }
        return str;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String str=cryptogram;
        while(true){
            String tmp = slicing(str);
            if(tmp.equals(str)){
                break;
            }
            else{
                str=tmp;
            }
        }

        return str;
    }
}
