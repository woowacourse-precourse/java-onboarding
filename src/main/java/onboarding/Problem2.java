package onboarding;

public class Problem2 {
    static String removeDup(String cryptoString){
        StringBuffer newString = new StringBuffer(cryptoString);
        for (int i=0; i<newString.length(); i++){
            if (newString.charAt(i) == newString.charAt(i+1)){
                newString.deleteCharAt(i);
                newString.deleteCharAt(i);
                break;
            }
        }
        return String.valueOf(newString);
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        for (int i=0; i<cryptogram.length(); i++){
            answer = removeDup(answer);
        }
        return answer;
    }
}
