package onboarding;

public class Problem3 {

    /*기능요구사항
        1. 1부터 주어진 수까지 확인하면서 박수를 몇번 쳐야하는지 확인한다.
        2. 각 숫자마다 3,6,9가 들어가는지 확인.
    * */
    public static int solution(int number) {
        int answer = 0;
        answer = playGame(number);
        return answer;
    }

    private static int playGame(int number) {
        int res = 0;

        for (int i = 1; i <= number ; i++) {
            int curr = i;
            while(curr>0){
                if(curr%10 == 3 || curr%10 == 6 || curr%10 == 9){
                    res++;
                }
                curr /= 10;
            }
        }

        return res;
    }
}
