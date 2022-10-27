package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int ClapBy369(int number){
        int cnt = 0;
        String str = String.valueOf(number);
        for(char c : str.toCharArray()){
            if((c == '3') || (c == '6') || (c == '9')){
                cnt++;
            }
        }
        return cnt;
    }
}