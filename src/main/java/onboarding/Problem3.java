package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = clap(number);
        return answer;
    }

    private static int clap(int number) {
        int count = 0;
        for (int j = 1; j <= number; j++) {
            String n = String.valueOf(j);
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == '3' || n.charAt(i) == '6' || n.charAt(i) == '9') {
                    count++;
                }
            }

        }
        //13
        // 3 6 9 13

        //33
        // 3 6 9 13 16 19 23 26 29 30 31 32 33
        return count;
    }

}
