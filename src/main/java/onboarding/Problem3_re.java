package onboarding;

public class Problem3_re {

    public static void main(String[] args){

//        int input = 13;
        int input = 33;
        System.out.println(solution(input));

    }


    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number+1; i++){
            int num = i;
            while(num != 0){
                int tmp = num%10;
                if (tmp == 3 || tmp == 6 || tmp == 9){
                    answer += 1;
                }
                num /= 10;
            }

        }

        return answer;
    }

}
