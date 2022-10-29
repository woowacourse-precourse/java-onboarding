package onboarding;
public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        for(int i=0; i<=number; i++){
            result+=check_num(i);
        }
        return result;
    }
    public static int check_num(int num){
        int result = 0;
        while (num>0){
            int n = num%10;
            if (n!=0 && n%3==0){
                result+=1;
            }
            num/=10;
        }
        return result;
    }
}
