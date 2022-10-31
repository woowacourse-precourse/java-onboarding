package onboarding;

public class Problem3 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution(13));
        System.out.println(solution(33));
    }
    public static int solution(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
        String numStr = Integer.toString(i);
        for (int j = 0; j < numStr.length(); j++) {
            String charStr = String.valueOf(numStr.charAt(j));
            if (charStr.equals("3") || charStr.equals("6") || charStr.equals("9"))
                clap += 1;
        }
        }
        return clap;
    }
}
