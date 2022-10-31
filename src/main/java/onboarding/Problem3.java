package onboarding;

public class Problem3 {
    /*
     * 1 ~ 10000 이므로 Brute Force 가능.
     * 각 숫자가 3,6,9를 몇개 포함하고 있는지 확인하는 digit369Counter를 3 ~ 해당 숫자까지 돌린다.
     */
    public static int solution(int number) {
        int answer = 0;
        for(int i=3; i<=number; i++){
            answer += digit369Counter(i);
        }
        return answer;
    }

    private static int digit369Counter(int number){
        int result =0;
        while(number != 0){
            int digit = number%10;
            if(digit%3 == 0 && digit != 0){
                result++;
            }
            number/=10;
        }
        return result;
    }

}
