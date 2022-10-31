package onboarding;

public class Problem4 {
    public static boolean check_error(String word)
    {
        if (word.length() < 1 || word.length() > 1000)
            return false;
        return true;
    }
    public static String solution(String word) {
        char now;
        String answer = "";

        if(!check_error(word))
            return answer;
        for (int i = 0; i < word.length(); i++)
        {
            now = word.charAt(i);
            int target = 'a';
            int add_val = 0;
            if (now >= 'a' && now <='z') {
                add_val = ('z' - now);
                target = 'a' + add_val;
            }
            else if (now >= 'A' && now <='Z') {
                add_val = ('Z' - now);
                target = 'A' + add_val;
            }else
                target = now;
            answer += (char)target;
        }
        return answer;
    }
}
