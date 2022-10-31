package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) answer+= countClap(i);
        return answer;
    }

    static int countClap(int n){
        int count = 0;
        for(char ch : String.valueOf(n).toCharArray())
            if (ch-'0' == 3 || ch-'0' == 6 || ch-'0' == 9) count++;
        return count;
    }
}
