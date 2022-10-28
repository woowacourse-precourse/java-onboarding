package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    public static int count369(int number) {
        int result = 0;
        String numStr = String.valueOf(number);

        for(char ch : numStr.toCharArray()) {
            int checkNum = Integer.parseInt(String.valueOf(ch));
            if(is369(checkNum))
                result++;
        }

        return result;
    }

    public static boolean is369(int checkNum) {
        if(checkNum == 3 || checkNum == 6 || checkNum == 9)
            return true;
        return false;
    }
}
