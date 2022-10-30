package onboarding;

public class Problem2 {
    public static Boolean haveDupe(String cryptogram){
        char[] chars = cryptogram.toCharArray();
        for(int i =0;i<cryptogram.length()-2;i++){
            if(chars[i]==chars[i+1]){
                return true;
            }
        }
        return false;
    }
    public static String solution(String cryptogram) {
        while(haveDupe(cryptogram)){
            char[] chars = cryptogram.toCharArray();
            for(int i =0;i<cryptogram.length()-2;i++){
                if(chars[i]==chars[i+1]){
                    cryptogram=cryptogram.substring(0,i)+cryptogram.substring(i+2);
                    System.out.println(cryptogram);
                    break;
                }
            }
        }
        String answer = "answer";
        return answer;
    }
}
