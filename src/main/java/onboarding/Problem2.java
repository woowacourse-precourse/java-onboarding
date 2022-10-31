package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean flag;
        do {
            StringBuilder temp = new StringBuilder();
            flag = false;
            temp.append(answer.charAt(0));
            for (int i = 1; i < answer.length(); i++) {
                if (answer.charAt(i - 1) != answer.charAt(i)) {
                    temp.append(answer.charAt(i));
                } else {
                    temp = new StringBuilder(temp.substring(0, temp.length() - 1));
                    flag = true;
                }
            }
            answer = temp.toString();
        } while (flag & answer.length() != 0);
        return answer;
    }
}
