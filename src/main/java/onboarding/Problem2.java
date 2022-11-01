package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int k = cryptogram.length();

        for(int i=k; i>0 ; i--){
            for(int j=0;j<cryptogram.length()-1;j++){
                if(cryptogram.charAt(j)==cryptogram.charAt(j+1)){
                    cryptogram = cryptogram.replaceAll(""+cryptogram.charAt(j)+cryptogram.charAt(j+1),"");
                    break;
                }
            }
        }
        answer = cryptogram;
        return answer;
    }
}
