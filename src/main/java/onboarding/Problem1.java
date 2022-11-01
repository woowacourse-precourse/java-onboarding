package onboarding;

import java.util.*;
import java.util.stream.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 예외사항
        // 1. 요소값 1~400 외
        // 2. 리스트 크기가 2가 아닌경우
        Integer[] pobiArr = pobi.stream().filter(s->s>=1||s<=400).toArray(Integer[]::new);
        Integer[] crongArr = crong.stream().filter(s->s>=1||s<=400).toArray(Integer[]::new);
        if(pobiArr.length == 2 && crongArr.length == 2){
            int fpobi = pobiArr[0];
            int spobi = pobiArr[1];
            int fcrong = crongArr[0];
            int scrong = crongArr[1];
            // 포비, 크롱 각각의 점수 구해
            String strFpobi = String.valueOf(fpobi);
            String strSpobi = String.valueOf(spobi);
            String strFcrong = String.valueOf(fcrong);
            String strScrong = String.valueOf(scrong);

            int pobiScore = Math.max(maxValue(strFpobi),maxValue(strSpobi));
            int crongScore = Math.max(maxValue(strFcrong),maxValue(strScrong));
            // 점수 비교하여 answer값 저장
            if(pobiScore>crongScore) answer = 1;
            else if(crongScore>pobiScore) answer = 2;
            else answer = 0;
            // 예외사항
            // 3. 연속된 두 값이 아닌경우
            // 4. 왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닌경우
            if((spobi-fpobi)!=1 || (scrong-fcrong)!=1 || (fpobi%2)!=1 || (spobi%2)!=0 || (fcrong%2)!=1 || (scrong%2)!=0)
                answer = -1;
        }else{
            answer = -1;
        }
        return answer;
    }

    public static int maxValue(String num){
        int plusNum = 0;
        int multipleNum = 1;
        for(int i=0;i<num.length();i++){
            plusNum += (num.charAt(i)-'0');
            multipleNum *= (num.charAt(i)-'0');
        }
        return Math.max(plusNum,multipleNum);
    }
}