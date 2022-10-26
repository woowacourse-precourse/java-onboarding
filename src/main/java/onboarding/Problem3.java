package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int containChar(char[] num, char tsn){
        int cnt = 0;
        for(int i=0; i<num.length; i++){
            if(num[i] == tsn) cnt++;
        }
        return cnt;
    }
}
