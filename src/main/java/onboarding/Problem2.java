package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        cryptogram+= "?";
        String word = "";

        for(int i=0; i<cryptogram.length(); i++){
            if(String.valueOf(cryptogram.charAt(i)).equals(word))
                continue;
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                word = String.valueOf(cryptogram.charAt(i));
            }else {
                word ="";
                sb.append(cryptogram.charAt(i));
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
