package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++){
            String temp = Integer.toString(i);
            int clap = 0;
            clap += temp.length() - temp.replaceAll("3","").length();
            clap += temp.length() - temp.replaceAll("6","").length();
            clap += temp.length() - temp.replaceAll("9","").length();

            answer += clap;
        }

        return answer;
    }
}
