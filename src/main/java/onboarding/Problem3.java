package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=3;i<=number;i++){
            answer+=get369(i);
        }

        return answer;
    }

    /**
     * 3.6.9 개수를 return하는 함수
     */
    private static int get369(int num){
        int count=0;

        while (num>0){
             count+=get_count(num);
             num=num/10;
        }
        return count;
    }

    /**
     * count 추가하는 함수
     */
    private static int get_count(int num){
        if(num%10!=0 && num%10%3==0)
            return 1;
        else
            return 0;
    }
}
