package onboarding;

public class Problem3 {

    public static int countNum(int number){
        int count = 0;
        for(int i = 1; i < number+1; i++){
            int temp = i;
            while(temp > 0){
                if((temp % 10) == 3 || (temp % 10) == 6 || (temp % 10) == 9)
                    count++;
                temp /= 10;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int answer = countNum(number);
        return answer;
    }
}
