package onboarding;

public class Problem2 {

    private static String deleteRepeat(String cryptogram){
        char previousChar = cryptogram.charAt(0);

        for(int i = 1; i < cryptogram.length(); i++){
            if(previousChar == cryptogram.charAt(i)){
                cryptogram = cryptogram.substring(0, i - 1).concat(cryptogram.substring(i + 1));
                i--;
            }
            else{
                previousChar = cryptogram.charAt(i);
            }
        }

        return cryptogram;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
