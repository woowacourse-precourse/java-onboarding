package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        for (int i=0; i<cryptogram.length()-1 ; i++){

            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
                i = 0;
            }

            if (cryptogram.length() == 2){
                if (cryptogram.charAt(0) == cryptogram.charAt(1)){
                    cryptogram = "";
                }
            }
        }
        answer = cryptogram;
        return answer;
    }
}
