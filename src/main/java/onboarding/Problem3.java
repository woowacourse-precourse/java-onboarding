package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = clap(number);
        return answer;
    }

    private static int clap(int number) {

        int numpp = 0;
        for (int i = 1; i <= number; i++) {
            String input = String.valueOf(i);
            for (int j = 0; j < input.length(); j++) {
                String count2 = input.substring(j, j + 1);
                System.out.println("j " + j);
                System.out.println("count2 is " + count2);
                int num = Integer.valueOf(count2);
                if (num != 0 && num % 3 == 0) {
                    numpp++;
                }
            }
        }
        return numpp;
    }
}
