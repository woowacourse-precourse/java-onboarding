package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = numberCheck(number);
        return answer;
    }
    private static int numberCheck(int input){
        int temp, result = 0;
        for(int i = 1; i <= input; i++){
            temp = i;
            while(temp > 0){
                int k = temp % 10;
                if(k == 3 || k == 6 || k == 9)
                    result += 1;
                temp /= 10;
            }
        }
        return result;
    }
}
