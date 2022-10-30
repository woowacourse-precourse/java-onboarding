package onboarding;

public class Problem4 {

    public static String solution(String word) {

        char tmp;
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<word.length(); i++) {

            tmp = word.charAt(i);

            if ( 64 < tmp && tmp < 91  ) tmp = (char) (155 - tmp);
            if ( 96 < tmp && tmp < 123 ) tmp = (char) (219 - tmp);

            answer.append(tmp);
        }

        return answer.toString();
    }

}
