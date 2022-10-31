package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        int check = 0;
        while(check==0) {
            check=1;
            cryptogram=answer;
            String temp_s =" ";
            char temp = ' ';
            for (int i = 0; i < cryptogram.length(); i++) {
                if (temp == cryptogram.charAt(i)) continue;
                if (i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    temp = cryptogram.charAt(i);
                    check=0;
                    continue;
                }
                temp=' ';
                temp_s += cryptogram.charAt(i);
            }
            answer=temp_s;

        }
        return answer.trim();
    }

    public static void main(String[] args) {
       System.out.println(solution("browoanoommnaon"));
    }

}
