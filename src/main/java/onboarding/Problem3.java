package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int ans = 0;
        for(int num=1; num<=number;num++){
            ans+=count369(Integer.toString(num));
        }
        return ans;
    }
    public static int count369(String strNum){
        return (int) strNum.chars()
                .filter(n-> n=='3' || n=='6' || n=='9')
                .count();
    }
}
