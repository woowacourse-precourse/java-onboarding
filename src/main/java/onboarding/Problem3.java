package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0;i<number+1;i++){
            int copy = i;
            while(copy != 0){
                if(copy % 10 == 3 || copy % 10 == 6 || copy % 10 == 9){
                    answer++;
                }
                copy /= 10;
            }
        }
        return answer;
    }

    public static void main(String[] agrs){
        System.out.println(solution(13));
        System.out.println(solution(33));
        System.out.println(solution(10000));
        System.out.println(solution(1));
    }
}
