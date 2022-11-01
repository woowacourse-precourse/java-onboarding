package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = count(number);

        return answer;
    }

    private static int count(int number) {
        int clapCount = 0;

        for (int num = 1; num <= number; num++) {  
            String n = Integer.toString(num);
            for (int numStr = 0; numStr < n.length(); numStr++) {
                if (n.charAt(numStr) == '3' || n.charAt(numStr) == '6' || n.charAt(numStr) == '9')
                    clapCount++;
            }
        }

        return clapCount;
    }
}
