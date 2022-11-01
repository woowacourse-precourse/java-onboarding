package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int clap=0;

        for (int i=1; i<=number; i++) {
            String s=Integer.toString(i);
            String[]num=s.split("");

            for (int j = 0; j < num.length; j++) {
                if (num[j].contains("3") || num[j].contains("6") || num[j].contains("9")) {
                    clap++;
                }
            }
        }
        answer=clap;
        return answer;
    }
}