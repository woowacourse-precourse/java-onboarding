package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Problem3 prob = new Problem3();
        answer = prob.clapcount(number);
        return answer;
    }
    public int clapcount(int number) {
        int count = 0;
        for(int i=1; i<=number; i++){
            if(i / 10 ==3 || i / 10 ==6 || i / 10==9){
                if(i%10==3 || i%10==6 || i%10==9){
                    count ++;
                }
                count++;
            }
            else if(i%10==3 || i%10==6 || i%10==9){
                count++;
            }
        }return count;
    }
}
