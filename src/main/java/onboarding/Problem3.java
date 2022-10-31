package onboarding;
/*
##기능 목록

1. 특정 숫자의 3 or 6 or 9를 포함하는 개수 계산
2. 1부터 해당 숫자까지 누적 박수 횟수 계산 및 반환

 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer += countNumber(i);
        }
        return answer;
    }

    public static int countNumber(int number){
        int count = 0;
        while(number != 0){
            int mod = number % 10;
            number /= 10;
            if(mod == 3 || mod == 6 || mod == 9){
                count++;
            }
        }
        return count;
    }

}
