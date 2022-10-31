package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int input = 1; input <= number ;input++){
            answer+= countingNumber(input);
        }
        return answer;
    }
    public static int countingNumber(int input){
        int count = 0;
        while(input!=0){
            if (input%10==3 || input%10==6 || input%10==9) count++;
            input/=10;
        }
        return count;
    }
}
