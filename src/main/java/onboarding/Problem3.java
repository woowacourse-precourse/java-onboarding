package onboarding;

public class Problem3 {
    public static int[] divide=new int[] {0,0,0,0,0};
    public static int[] division=new int[] {10000,1000,100,10,10};
    public static int[] numbercount=new int[] {0,0,0,0,0};


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

        numbercount[4]=divide[4]/3;
    }

    public static void doublefigure(){
        numbercount[3]=3*divide[3]+threesixnine(divide[3])*10+divide[4]+1;
    }

    public static void triplefigure(){
        numbercount[2]=60*divide[2]+threesixnine(divide[2])*100+divide[3]*10+divide[4]+1+numbercount[3];
    }

    public static void quadruplefigure(){
        numbercount[1]=900*divide[1]+threesixnine(divide[1])*1000+divide[2]*100+divide[3]*10+divide[4]+1+numbercount[2];
    }

    public static int addCount(){
        int count=0;
        for(int i=0;i<5;i++){
            count+=numbercount[i];
        }
        return count;
    }


    public static int solution(int number) {
        int answer = 0;
        dividenumber(number);
        singlefigure();
        doublefigure();
        triplefigure();
        quadruplefigure();
        answer=addCount();
        return answer;
    }
}
