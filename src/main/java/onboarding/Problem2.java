package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String removeDup(String cryptogram){
        String result = "";
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if(cryptogram.charAt(i) != cryptogram.charAt(i + 1)){
                result += String.valueOf(cryptogram.charAt(i));
            } else {
                i++;
            }
            if (i == cryptogram.length() - 2)
                result += String.valueOf(cryptogram.charAt(i + 1));
        }

        if (cryptogram.length() != result.length())
            result = removeDup(result);

        return result;
    }
}
