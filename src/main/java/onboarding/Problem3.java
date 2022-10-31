package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for(int i = 1; i < number + 1; i++){
            String tmp = Integer.toString(i);
            String[] tmp2 = tmp.split("");
            for(String j : tmp2){
                int tmp3 = Integer.parseInt(j);
                if(tmp3 == 3 || tmp3 == 6 || tmp3 == 9){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
