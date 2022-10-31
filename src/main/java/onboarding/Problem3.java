package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer += calcNum(i);
        }

        return answer;
    }
    static int calcNum(int param){
        int cnt=0;
        for(char a : String.valueOf(param).toCharArray()){
            if(a-'0' == 3 || a-'0' == 6 || a-'0' == 9) cnt++;
        }
        return cnt;
    }
}
