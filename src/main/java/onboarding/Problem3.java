package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int cnt = 0;

        for (int i = 1; i < number+1; i++){
            int j = i;
            while(j > 0){
                if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9){
                    cnt++;
                }
                j /= 10;       // 나누어서 맨 뒤의 수 없앰
            }
        }
        answer = cnt;

        return answer;
    }
}


