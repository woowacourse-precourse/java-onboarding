package onboarding;

public class Problem3 {

    static int cntNum(int num){
        int cnt = 0;
        while(num > 0){
            if(num%10 == 3 || num%10 == 6 || num%10 == 9){
                cnt += 1;
            }
            num = num/10;
        }
        return cnt;
    }

    static int play369(int num){
        int clap = 0;
        for(int i= 1; i < num+1; i++){
            clap += cntNum(i);
        }
        //System.out.println(clap);
        return clap;
    }

    public static int solution(int number) {
        return play369(number);
    }
}
