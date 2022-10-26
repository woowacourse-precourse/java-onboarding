package onboarding;

public class Problem3 {
    public static int count369(int n){
        return (int)String.valueOf(n).chars()
                .filter(o -> o=='3' || o=='6' || o=='9')
                .count();
    }

    public static int solution(int number) {
        int sum=0;
        for(int i=1; i<=number; i++)
            sum+=count369(i);

        return sum;
    }
}
