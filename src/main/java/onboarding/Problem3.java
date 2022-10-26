package onboarding;

public class Problem3 {
    static int answer = 0;

    public static int solution(int number) {
        answer = pro(number);

        return answer;
    }

    static int pro(int number) {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            String s = String.valueOf(i);
            count += count(s);
        }

        return count;
    }

    static int count(String number) {
        int count = 0;

        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c == '3' || c == '6' || c == '9') count++;
        }

        return count;
    }
}
