package onboarding;

public class Problem2 {
    public static String decoding(String cryptogram) {
        StringBuilder result = new StringBuilder(cryptogram);
        for (int i = 0; i < cryptogram.length()-1; i++) {
            char left = cryptogram.charAt(i);
            char right = cryptogram.charAt(i+1);

            if (left==right){
                result=result.deleteCharAt(i+1);
                result=result.deleteCharAt(i);
                return decoding(result.toString());
            }
        }
        return result.toString();
    }

    public static String solution(String cryptogram) {
        String answer = decoding(cryptogram);
        return answer;
    }
}
