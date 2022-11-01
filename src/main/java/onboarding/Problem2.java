package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (!answer.equals(decode(answer))) {
            answer = decode(answer);
        }

        return answer;
    }

    public static String decode(String str){
        char prev = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (prev == str.charAt(i)){
                return str.substring(0, i-1) + str.substring(i + 1);
            }
            prev = str.charAt(i);
        }
        return str;
    }
}
