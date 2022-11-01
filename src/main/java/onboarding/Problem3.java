package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp = 0;
        int current_num = 1;

        for(int i=1; i<=number; i++){
            current_num = i;
            temp = current_num;
            while(temp>0){
                current_num = temp%10;
                if(current_num == 3 || current_num == 6 || current_num == 9) {
                    answer ++;
                }
                temp /= 10;
            }
        }

        return answer;
    }

    public static void main (String [] args) {

        int number = 33;

        Problem3 prob = new Problem3();
        System.out.println(prob.solution(number));
    }

}
