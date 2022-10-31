package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(true){
            if(pattern(answer).length() > 0){
                answer = pattern_del(answer,pattern(answer));
            }else{
                break;
            }
        }
        return answer;
    }
    public static String pattern(String a){
        char[] chars = a.toCharArray();
        String answer = "";
        for(int i=0; i< chars.length-1; i++){
            if(chars[i] == chars[i+1]){
                answer += chars[i];
                answer += chars[i];
            }
        }
        return answer;
    }
    public static String pattern_del(String a, String b){
        String pattern = b;
        String answer = a.replaceAll(pattern,"");
        return answer;
    }
}

