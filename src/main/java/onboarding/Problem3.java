package onboarding;

public class Problem3 {
    //number가 한 자리 수일 경우
    public static int countOneFigures(int number){
        int count = 0;

        for(int i =0; i<=number; i++){
            if(i%3 == 0 & i!=0)
                count++;
        }
        return count;

    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
