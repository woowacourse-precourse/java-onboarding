package onboarding;

public class Problem3 {
    public static int solution(int number) { // 3 6 9 Game
        // 박수 치는 개수
        int count = 0;

        for(int i = 1; i < number+1; i++){
            // 1부터 number까지
            int cur_num = i;

            while(cur_num != 0){
                int n = cur_num % 10;

                // 일의 자리 처리
                if(n == 3 || n == 6 || n == 9){
                    count++;
                }

                // 십의 자리 이상 처리
                cur_num /= 10;
            }
        }

        return count;
    }
/*
    public static void main(String[] args) { // TEST
        int num = 33;

        solution(num);
    }

 */
}
