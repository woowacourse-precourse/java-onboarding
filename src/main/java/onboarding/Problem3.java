package onboarding;

public class Problem3 {

    static boolean Exception(int number) {
        return (0 < number && number <= 10000) ? false : true;
    }
    public static int solution(int number) {
        int answer = 0;

        if (Exception(number))
            return answer;
        else
            return 1;

    }

    public static void main(String argv[]){
        System.out.println(solution(10001));
        System.out.println(solution(0));
        System.out.println(solution(10000));
        System.out.println(solution(1));
    }
}
