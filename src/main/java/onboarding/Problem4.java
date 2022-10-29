package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char origin;
        char reversed;

        for (int i = 0; i < word.length(); i++) {
            origin = word.charAt(i);

            if(origin >= 65 && origin <= 97) {
                reversed = (char) (155 - origin);
                answer = answer + (String.valueOf(reversed));
                continue;
            }

            if (origin >= 97 && origin <= 122) {
                reversed = (char) (219 - origin);
                answer = answer + (String.valueOf(reversed));
                continue;
            }

            answer = answer + (String.valueOf(origin));
            continue;
        }

        System.out.println(answer);

        return answer;
    }
}
