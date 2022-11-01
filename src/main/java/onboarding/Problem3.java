package onboarding;

public class Problem3 {
    public static int countNum(int number){
        int count = 0;
        for(int i = 1; i < number+1; i++){ // 1부터 number까지
            int temp = i;
            while(temp > 0){
                if((temp % 10) == 3 || (temp % 10) == 6 || (temp % 10) == 9) // 나머지가 3, 6, 9 중 하나이면
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