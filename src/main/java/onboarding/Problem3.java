package onboarding;

public class Problem3 {
    static int[]a=new int[10001];
    static void o(){
        int i=1,j,v;
        for(;i<10001;i++){
            a[i]=a[i-1];
            j=1;
            for(;j<=i;j*=10){
                v=i/j%10;
                a[i]+=v==3|v==6|v==9?1:0;
            }
        }
    }
    public static int solution(int number) {
        o();
        return a[number];
    }
}
