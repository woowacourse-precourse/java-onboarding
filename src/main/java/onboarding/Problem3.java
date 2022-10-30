package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

class Game{
    static int countContainThree(int number){
        int cnt = 0;
        while(number != 0){
            int rest = number % 10;
            if(rest/3 != 0 && (rest % 3) == 0) cnt++;
            number /= 10;
        }
        return cnt;
    }
}
