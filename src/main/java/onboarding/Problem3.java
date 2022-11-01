package onboarding;

public class Problem3 {

    private static int count3(int number){
        int cnt = 0;
        int curNum;

        while(number>0){
            curNum = number%10;
            if(curNum!=0&&curNum%3==0) cnt+=1;
            number/=10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<number+1; i++){
            answer += count3(i);
        }

        return answer;
    }
}
