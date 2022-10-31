package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for(int i = 1; i < number + 1; i++){
            String[] letters = String.valueOf(i).split("");
            for (int j = 0; j < letters.length; j++){
                int cnt_number = Integer.valueOf(letters[j]);
                if(cnt_number == 3 || cnt_number == 6 || cnt_number == 9){
                    cnt = cnt + 1;
                }
            }
        }
        return cnt;
    }
}
