package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (!answer.equals(changeStr(answer))) {
            answer = changeStr(answer);
        }

        return answer;
    }

    public static String changeStr(String str){
        char temp = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (temp == str.charAt(i)){
                return str.substring(0, i-1) + str.substring(i + 1);
            }
            temp = str.charAt(i);
        }
        return str;
    }
}
