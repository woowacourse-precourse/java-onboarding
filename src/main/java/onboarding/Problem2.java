package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String[] array = new String[1000];

        for (int i = 0; i < array.length; i++) {

            if (array[i] == array[i - 1]) {
                return null;
            }

            return array[i];
        }


        return answer;
    }
}


