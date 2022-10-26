package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // pobi와 crong의 길이는 2이다.
        // pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

        // 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        // 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int pobiMax =0;
        int crongMax =0;

        int pobiPlus = pobi.get(0)+pobi.get(1);
        int crongPlus = crong.get(0)+crong.get(1);

        int pobiTimes = pobi.get(0)+pobi.get(1);
        int crongTimes = crong.get(0)+crong.get(1);

        if(pobiPlus > pobiTimes) {pobiMax = pobiPlus;}
        else pobiMax = pobiTimes;

        if(crongPlus > crongTimes) {crongMax = crongPlus;}
        else crongMax = crongTimes;


        if(pobiMax>crongMax) {System.out.print("|" +pobi+ "|" +crong+ "| 1 |");return 1;}
        else if(pobiMax<crongMax) {System.out.print("|" +pobi+ "|" +crong+ "| 1 |");return 2;}
        else {System.out.print("|" +pobi+ "|" +crong+ "| 0 |");return 0;}

    }


}