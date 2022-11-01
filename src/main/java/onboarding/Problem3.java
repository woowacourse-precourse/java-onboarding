package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1;i<=number;i++){
            String[] s = String.valueOf(i).split("");
            for (String value : s) {
                if (Integer.parseInt(value) == 3 || Integer.parseInt(value) == 6 || Integer.parseInt(value) == 9)
                    answer++;
            }
        }


        return answer;
    }
}
