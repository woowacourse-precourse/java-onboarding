package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    public static String decrypt(String cryptogram){
        StringBuilder result = new StringBuilder(cryptogram.length());
        boolean done = true;

        for (int i = 0; i < cryptogram.length(); i++){
            if(i - 1 >= 0){
                if (cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                    done = false;
                    continue;
                }
            }
            if (cryptogram.length() > i + 1) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    done = false;
                    continue;
                }
            }
            result.append(cryptogram.charAt(i));
        }

        if (!done)
            return decrypt(result.toString());
        else
            return result.toString();
    }
}
