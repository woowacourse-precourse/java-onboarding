package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean check;
        StringBuilder answer;

        do {
            check = false;
            answer = new StringBuilder();
            for(int i = 0; i < cryptogram.length();) {
                char target = cryptogram.charAt(i);
                int next;
                for (next = i + 1; next < cryptogram.length() && cryptogram.charAt(next) == target; next++);

                if (next - i == 1)
                    answer.append(target);
                else
                    check = true;

                i = next;
            }
            cryptogram = answer.toString();
        } while (check);

        return answer.toString();
    }
}
