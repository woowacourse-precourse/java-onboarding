package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="";
        int last = 0;
        int flag = 1;
        StringBuilder str = new StringBuilder(cryptogram);

        while (flag == 1) {
            flag = 0;
            for (int i = 0; i < str.length()-1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    str.delete(i, i + 2);
                    flag = 1;
                    break;
                }
            }
        }
        answer = str.toString();

        return answer;
    }
}
