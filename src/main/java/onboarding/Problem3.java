package onboarding;

public class Problem3 {
    public static int get369Count(int number){
        int mod;
        int count = 0;

        while(number != 0){
            mod = number % 10;
            if (mod == 3 || mod == 6 || mod == 9){
                ++count;
            }
            number = number / 10;
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n<=number; n++){
            answer += get369Count(n);
        }

        return answer;
    }
}
