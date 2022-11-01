package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Problem1 {
    List<Integer>pobi;
    List<Integer>crong;
    Random random = new Random();
    void run()
    {
        pobi = new ArrayList<Integer>();
        crong = new ArrayList<Integer>();
        int num1 = 2*random.nextInt(200)+1;
        pobi.add(0,num1);
        pobi.add(1,num1+1);
        int num2 = 2*random.nextInt(200)+2;
        crong.add(0,num2);
        crong.add(1,num2+1);
        int result=solution(pobi,crong);

        switch(result)
        {
            case 0:
                System.out.println("무승부");
                break;
            case 1:
                System.out.println("pobi 승");
                break;
            case 2:
                System.out.println("crong 승");
                break;
            default:
                System.out.println("예외사항 발생");
                break;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiNum=0;
        int crongNum=0;

        for(int i = 0;i<pobi.size();i++)
        {
            pobiNum+=pobi.get(i);
            crongNum+=crong.get(i);
        }
        if(pobiNum>crongNum)
            answer=1;
        else if(pobiNum<crongNum)
            answer=2;
        else if(pobiNum==crongNum)
            answer=0;
        else
            answer=-1;

        return answer;
    }
    public static void main(String [] args)
    {
        Problem1 p1 = new Problem1();
        p1.run();
    }
}