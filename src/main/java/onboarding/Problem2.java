package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String temp = "";
        boolean flag = false;
        do {
            temp = "";
            flag = false;
            temp += answer.charAt(0);
            for (int i = 1; i < answer.length(); i++) {
                if (answer.charAt(i - 1) != answer.charAt(i)) {
                    temp += answer.charAt(i);
                } else {
                    temp = temp.substring(0, temp.length() - 1);
                    flag = true;
                }
            }
            answer = temp;
        } while (flag == true & answer.length()!=0);        return answer;
    }
}
