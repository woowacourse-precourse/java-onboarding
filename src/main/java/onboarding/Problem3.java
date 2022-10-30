package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = Count369(number);
        return answer;
    }
    public static int Count369(int num){
        String str369 = "";
        int cnt = 0;

        for(int i = 1 ; i <= num; i++){
            str369 = str369 + i;
        }

        for(int i = 0 ; i < str369.length(); i++){
            int tmp =str369.charAt(i);
            if (tmp == '3') cnt++;
            else if (tmp == '6') cnt++;
            else if (tmp == '9') cnt++;
        }

        return cnt;
    }
}
