package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            if(i < 10) {
                if(i == 3 || i == 6 || i == 9) {
                    answer++;
                }
            }
            else
            {
                String num_str = String.valueOf(i);

                for(int j = 0; j < num_str.length(); j++) {
                    if(num_str.charAt(j) == '3' || num_str.charAt(j) == '6' || num_str.charAt(j) == '9') {
                        answer++;
                    }
                }
            }
        }

        System.out.println("number\tresult");

        System.out.println(number + "\t\t" + answer);

        return answer;
    }
}
