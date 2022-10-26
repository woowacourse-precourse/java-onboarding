package onboarding;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;


class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        pobi = new ArrayList<>();
        crong = new ArrayList<>();
//////////////////////////////////////////////////////////////////////////
        int pobiPickNum = (int)(Math.random()*(398-3+1)) + 3;

        if (pobiPickNum % 2 == 1) {
            pobi.add(pobiPickNum);
            pobi.add(pobiPickNum+1);
        }else {
            pobi.add(1, pobiPickNum);
            pobi.add(0, pobiPickNum-1);
        }

        // pobi의 배열에서 덧셈, 곱셈 한 것 중 max 선택하여 저장.
        int pobiAddNum = 0;
        int pobiMulNum = 1;
        String to;
        int toNum = 0;
        ArrayList<Integer> wholeNumber = new ArrayList<>();


        for (int i = 0 ; i < pobi.size(); i++) {
            to = Integer.toString(pobi.get(i));

            //System.out.println(to.length()); // 문자열에서 .length 사용.
            for ( int j = 0 ; j < to.length(); j++) {
                toNum = Integer.parseInt(to.substring(j, j+1));
                pobiAddNum += toNum;
                pobiMulNum *= toNum;

                // 각각의 자릿수 들을 더해준 수와, 곱해준 수 작성.
            }
            wholeNumber.add(pobiAddNum);
            wholeNumber.add(pobiMulNum);
            pobiAddNum = 0;
            pobiMulNum = 1;
        }
        int max = Collections.max(wholeNumber);

/////////////////////////////////////////////////////////////////////////////////////
        int crongPickNum = (int)(Math.random()*(398-3+1)) + 3;

        if (crongPickNum % 2 == 1) {
            crong.add(crongPickNum);
            crong.add(crongPickNum+1);
        }else {
            crong.add(1, crongPickNum);
            crong.add(0, crongPickNum-1);
        }

        // crong의 배열에서 덧셈, 곱셈 한 것 중 max 선택하여 저장.
        int crongAddNum = 0;
        int crongMulNum = 1;
        String to2;
        int toNum2 = 0;
        ArrayList<Integer> wholeNumber2 = new ArrayList<>();


        for (int i = 0 ; i < crong.size(); i++) {
            to2 = Integer.toString(crong.get(i));

            //System.out.println(to.length()); // 문자열에서 .length 사용.
            for ( int j = 0 ; j < to2.length(); j++) {
                toNum2 = Integer.parseInt(to2.substring(j, j+1));
                crongAddNum += toNum2;
                crongMulNum *= toNum2;

                // 각각의 자릿수 들을 더해준 수와, 곱해준 수 작성.
            }
            wholeNumber2.add(crongAddNum);
            wholeNumber2.add(crongMulNum);
            crongAddNum = 0;
            crongMulNum = 1;
        }
        int max2 = Collections.max(wholeNumber2);

        if (max > max2) {
            answer = 1;
        }else if (max < max2){
            answer = 2;
        }else if (max == max2) {
            answer = 0;
        }else {
            answer = -1;
        }
        return answer;


    }
}