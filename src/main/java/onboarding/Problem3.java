package onboarding;

public class Problem3 {
    public static int countNum (int i, char findNum) {
        int count = 0;
        String c = String.valueOf(i);
        for (char a : c.toCharArray()) {
            if (a == findNum) count += 1;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}