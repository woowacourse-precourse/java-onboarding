package onboarding;

public class Problem3 {
    public static int solution(int number) {
        try {
            if (number < 1 || number > 10000)
                throw new Exception("number의 범위가 잘못되었습니다");
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
            return -1;
        }

        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer += check(i);
        }
        return answer;
    }
    static int check(int i) {
        int cnt = 0;
        while(i != 0) {
            if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9)
                cnt++;
            i /= 10;
        }
        return cnt;
    }
}
