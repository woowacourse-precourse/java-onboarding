package onboarding;

public class Problem3 {
    public static int solution(int number) {
        //10 단위로 1의자리 3 6 9 3번
        //100 단위로 10의자리 3 6 9 30번
        //1000단위로 100의자리 3 6 9 300번
        int answer=0;
        int cnt,next_num;
        if(number<10)
            cnt=0;
        else if(number<100)
            cnt=1;
        else if(number<1000)
            cnt=2;
        else
            cnt=3;
        switch (cnt){
            case 3:
                next_num=number/1000;
                number%=1000;
                answer+=300*next_num;
                if(next_num%3==0)
                    answer+=number+1;
            case 2:
                next_num=number/100;
                number%=100;
                answer+=30*next_num;
                if(next_num%3==0)
                    answer+=number+1;
            case 1:
                next_num=number/10;
                number%=10;
                answer+=3*next_num;
                if(next_num%3==0)
                    answer+=number+1;
            case 0:
                answer+=number/3;

        }
        return answer;
    }
}
