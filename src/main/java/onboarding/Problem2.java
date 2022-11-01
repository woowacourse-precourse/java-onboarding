package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        for (int i = 0; i < cryptogram.length(); i++)
        {
            if (answer.length() != 0)
                if (answer.charAt(answer.length() - 1) == cryptogram.charAt(i))
                {
                    answer = answer.substring(0, answer.length() - 1);
                    continue;
                }
            answer += cryptogram.charAt(i);
        }
        return answer;
    }
}
