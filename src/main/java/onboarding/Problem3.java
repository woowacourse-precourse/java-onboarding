package onboarding;

public class Problem3 {
    // 손뼉 치는 횟수 Count
    static int numCounter(int curNum){
        int count = 0;
        while(curNum > 1){
            // 숫자의 1의자리부터 높은 자릿수 순서대로 3, 6, 9가 들어가는지 확인
            int remainder = curNum % 10;
            if(remainder == 3 || remainder == 6 || remainder == 9){
                count += 1;
            }
            curNum /= 10;
        }
        return count;
    }
    // 1부터 제시된 숫자까지 누적된 손뼉 횟수 Count
    static int clapCounter(int clapNum){
        int count = 0;
        while(clapNum>0){
            count += numCounter(clapNum);
            clapNum -= 1;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = clapCounter(number);
        return answer;
    }
}
