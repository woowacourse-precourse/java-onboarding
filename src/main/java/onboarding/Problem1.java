package onboarding;

import java.util.List;
//        책을 임의로 펼친다.
//        왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//        오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//        2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
//        점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
//        시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
//        포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때,
//        포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0)+1 != pobi.get(1)) return -1;
        if(crong.get(0)+1 != crong.get(1)) return -1;
        String pobiStr1 = pobi.get(0) + "";
        String pobiStr2 = pobi.get(1) + "";
        String crongStr1 = crong.get(0) + "";
        String crongStr2 = crong.get(1) + "";
        int pobiPlus1 = 0;
        int pobiMul1 = 1;
        int pobiPlus2 = 0;
        int pobiMul2 = 1;
        int pobiNum1 = 0;
        int pobiNum2 = 0;
        int crongPlus1 = 0;
        int crongMul1 = 1;
        int crongPlus2 = 0;
        int crongMul2 = 1;
        int crongNum1 = 0;
        int crongNum2 = 0;
        for (int i = 0; i < pobiStr1.length(); i++) {
            pobiPlus1 += Integer.parseInt(pobiStr1.charAt(i) + "");
            pobiMul1 *= Integer.parseInt(pobiStr1.charAt(i) + "");
        }
        pobiNum1 = pobiPlus1 >= pobiMul1 ? pobiPlus1 : pobiMul1;
        for (int i = 0; i < pobiStr2.length(); i++) {
            pobiPlus2 += Integer.parseInt(pobiStr2.charAt(i) + "");
            pobiMul2 *= Integer.parseInt(pobiStr2.charAt(i) + "");
        }
        pobiNum2 = pobiPlus2 >= pobiMul2 ? pobiPlus2 : pobiMul2;
        pobiNum1 = pobiNum1 >= pobiNum2 ? pobiNum1 : pobiNum2;

        for (int i = 0; i < crongStr1.length(); i++) {
            crongPlus1 += Integer.parseInt(crongStr1.charAt(i) + "");
            crongMul1 *= Integer.parseInt(crongStr1.charAt(i) + "");
        }
        crongNum1 = crongPlus1 >= crongMul1 ? crongPlus1 : crongMul1;
        for (int i = 0; i < crongStr2.length(); i++) {
            crongPlus2 += Integer.parseInt(crongStr2.charAt(i) + "");
            crongMul2 *= Integer.parseInt(crongStr2.charAt(i) + "");
        }
        crongNum2 = crongPlus2 >= crongMul2 ? crongPlus2 : crongMul2;
        crongNum1 = crongNum1 >= crongNum2 ? crongNum1 : crongNum2;
        if (pobiNum1 > crongNum1) answer = 1;
        if (pobiNum1 == crongNum1) answer = 0;
        if (pobiNum1 < crongNum1) answer = 2;


        return answer;
    }
}