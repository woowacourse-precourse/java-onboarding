package onboarding;

public class Problem2 {
    private static boolean checkSame(char ch1, char ch2){
        if (ch1 == ch2){
            return true;
        }
        return false;
    }
    public static String solution(String cryptogram) {
        StringBuffer answer = new StringBuffer("");
        for(int i = 0; i < cryptogram.length(); i++){
            if (answer.length() > 0 &&
                    checkSame(cryptogram.charAt(i), answer.charAt(answer.length() -1))){
                answer.deleteCharAt(answer.length() - 1);
            }
            else{
                answer.append(cryptogram.charAt(i));
            }
        }
        return answer.toString();
    }
}
