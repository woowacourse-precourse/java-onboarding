package onboarding;

public class Problem4 {

    public static String solution(String word) {

        char tmp;
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<word.length(); i++) {

            tmp = word.charAt(i);

            if ( Character.isUpperCase(tmp) ) tmp = (char) (155 - tmp);
            if ( Character.isLowerCase(tmp) ) tmp = (char) (219 - tmp);

            answer.append(tmp);
        }

        return answer.toString();
    }

}
