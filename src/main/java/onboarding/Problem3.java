package onboarding;

public class Problem3 {
    public int count369(int checkNum){
        int cnt = 0;
        while(checkNum!=0){
            int digit = checkNum%10;
            if(digit==3 || digit==6 || digit==9) cnt++;
            checkNum/=10;
        }
        return cnt;
    }
    public static int solution(int number) {
        Problem3 T = new Problem3();
        int answer = 0;
        for(int checkNum=1; checkNum<=number; checkNum++){
            answer+=T.count369(checkNum);
        }
        return answer;
    }
}
