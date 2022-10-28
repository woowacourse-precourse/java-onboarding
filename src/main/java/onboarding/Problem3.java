package onboarding;

public class Problem3 {
    public  static  void catchException(int num){
        assert (num>=1);
        assert (num<=10000);
    }

    public static int solution(int number) {
        catchException(number);
        int answer = 0;
        return answer;
    }
}
