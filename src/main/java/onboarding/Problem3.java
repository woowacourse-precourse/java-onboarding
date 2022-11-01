package onboarding;

public class Problem3 {

    //기능 1.
    public static int solution(int number) {
        int answer = 0;
        int num = number;
        int [] divNum = {1000, 100, 10, 1};
        for (int i = 0; i <= num; i++) {
            int su = i;
            for (int j = 0; j < 4; j++) {
                int mok = su/divNum[j];
                su %= divNum[j];
                if(mok != 0 && mok%3 == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
