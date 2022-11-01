package onboarding;

public class Problem2 {

    public static String slicing(String str){
        int len = str.length();
        for(int i=1; i < len; i++){
            char tStr = str.charAt(i-1);
            if(tStr == str.charAt(i))
                return str.substring(0, i-1) + str.substring(i+1, len);
        }
        return str;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String str = cryptogram;
        while(!slicing(str).equals(str)) str=slicing(str);
        return str;
    }
}