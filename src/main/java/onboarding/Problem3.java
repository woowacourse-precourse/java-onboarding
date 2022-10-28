package onboarding;

public class Problem3 {
    public static int[] divide=new int[] {0,0,0,0,0};
    public static int[] division=new int[] {10000,1000,100,10,10};
    public static int count=0;


    public static void dividenumber(int number){
        for(int i=0;i<4;i++){
            divide[i]=number/division[i];
        }
        divide[4]=number%division[4];
    }

    public static int threesixnine(int number){
        if(number<4){
            return 0;
        }else if(number<7){
            return 1;
        }else{
            return 2;
        }
    }

    public static void singlefigure(){
        count=divide[4]/3;
    }


    public static int solution(int number) {
        int answer = 0;

        return answer;
    }
}
