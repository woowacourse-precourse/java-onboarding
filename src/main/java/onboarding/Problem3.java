package onboarding;

public class Problem3 {
    static int count=0;
    static int check(int a){
        int count=0;
        while(a>0){
            int num=a%10;
            if(num==3 || num==6 || num==9) count++;
            a/=10;
        }
        return count;
    }
    public static int solution(int number) {
        int count=0;
        for(int i=1;i<=number;i++){
            count+=check(i);
        }
        return count;
    }
}
