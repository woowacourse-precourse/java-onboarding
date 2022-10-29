package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = checkNumber(number);
        return answer;
    }
    // 박수 세기
    public static int countClap(int number){
        int count = 0;
        while(number != 0){
            if(number%10 ==3 || number%10 ==6 || number%10==9){
                count++;
            }
            number /= 10;
        }
        return count;
    }
    // 1번부터 번호까지 돌면서 3,6,9 확인
    public static int checkNumber(int number){
        int count = 0;
        for(int i=1; i<=number; i++){
            count += countClap(i);
        }
        return count;

    }
}
