package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 3.6.9 개수를 return하는 함수 구현
     */
    private static int get369(int num){
        int count=0;

        while (num>0){
             if(num%10%3==0){
                 count++;
             }
             num=num/10;
        }
        return count;
    }
}
