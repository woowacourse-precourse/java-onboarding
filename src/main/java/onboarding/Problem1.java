package onboarding;

import java.util.List;
import java.util.Scanner;


public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        Scanner pobiLeftInput = new Scanner(System.in);
        int pobiLPage = pobiLeftInput.nextInt();
        Scanner pobiRightInput = new Scanner(System.in);
        int pobiRPage = pobiRightInput.nextInt();

        Scanner crongLeftInput = new Scanner(System.in);
        int crongLPage = crongLeftInput.nextInt();
        Scanner crongRightInput = new Scanner(System.in);
        int crongRPage = crongRightInput.nextInt();


        pobi.add(pobiLPage);
        pobi.add(pobiRPage);
        crong.add(crongLPage);
        crong.add(crongRPage);

        for(int i = 0; i<)






        return answer;
    }

}