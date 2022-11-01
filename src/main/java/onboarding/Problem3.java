package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int[] num = new int[4];
        int num1=0, num2=0, num3=0, num4=0;
        int i = 0;
        if(number == 10000){
            answer= 12000;
        }

        while(number!=0){
            num[i]= number%10;
            number /= 10;
            i++;
        }
        if(num[0]==9){num1+=3;}else if (num[0]<3){num1+=0;}else if (num[0]<6){num1+=1;}else if (num[0]<9){num1+=2;}
        if(num[1]<3){num2+=num[1]*3;}else if (num[1]==3){num2=10+num[0]*1;}else if (num[1]<6){num2=10+num[1]*3;}else if (num[1]==6){num2+=29+num[0]*1;}else if (num[1]<9){num2=20+num[1]*3;}else if (num[1]==9){num2+=48+num[0]*1;}
        if(num[2]<3){num3+=num[2]*60;}else if (num[2]==3){num3=181+num[1]*10+num[0]*1;}else if (num[2]<6){num3=100+num[2]*60;}else if (num[2]==6){num3+=461+num[1]*10+num[0]*1;}else if (num[2]<9){num3=200+num[2]*60;}else if (num[2]==9){num3+=741+num[1]*10+num[0]*1;}
        if(num[3]<3){num4+=num[3]*900;}else if (num[3]==3){num4=2701+num[2]*100+num[1]*10+num[0]*1;}else if (num[3]<6){num4=1000+num[3]*900;}else if (num[3]==6){num4+=6401+num[2]*100+num[1]*10+num[0]*1;}else if (num[3]<9){num4=2000+num[3]*900;}else if (num[3]==9){num4+=10101+num[2]*100+num[1]*10+num[0]*1;}

        answer = num4+num3+num2+num1;


        return answer;
    }
}
