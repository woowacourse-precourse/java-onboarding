package onboarding;

import java.util.List;
import java.util.Iterator;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*
        책을 임의로 펼친다.
        왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다
         */

        // pobi 와 crong이 계산했을 때 가장 큰 페이지 연산 결과를 저장할 변수
        int pobiFinalBookPageNumber = Integer.MAX_VALUE;
        int crongFinalBookPageNumber = Integer.MAX_VALUE;

        // pobi 와 crong 의 페이지들을 순회할 iterator
        Iterator<Integer> pobiBookPageList = pobi.iterator();
        Iterator<Integer> crongBookPageList = crong.iterator();

        //pobi 와 crong 의 페이지 값 계산
        while (pobiBookPageList.hasNext() && crongBookPageList.hasNext()){
            //순회하는 페이지 수 계산 (덧셈, 곱셈) 저장 변수

            int tempPobiBookPageForPlus = pobiBookPageList.next();
            int tempCrongBookPageForPlus = crongBookPageList.next();
            int tempPobiBookPageForMultiple = pobiBookPageList.next();
            int tempCrongBookPageForMultiple = crongBookPageList.next();


            //순휘하는 페이지 값에 대한 연산
            int tempPobiBookPagePlus=0;
            int tempCrongBookPagePlus=0;

            int tempPobiBookPageMultiple=1;
            int tempCrongBookPageMultiple=1;

            //pobi 덧셈 연산 
            while (tempPobiBookPageForPlus!=0){
                tempPobiBookPagePlus+= tempPobiBookPageForPlus%10;
                tempPobiBookPageForPlus/=10;
            }
            
            //crong 덧셈 연산
            while (tempCrongBookPageForPlus!=0){
                tempPobiBookPagePlus+= tempCrongBookPageForPlus%10;
                tempCrongBookPageForPlus/=10;
            }

            //pobi 곱셈 연산
            while (tempPobiBookPageForMultiple!=0){
                tempPobiBookPagePlus+= tempPobiBookPageForMultiple%10;
                tempPobiBookPageForMultiple/=10;
            }

            //crong 곱셈 연산
            while (tempCrongBookPageForPlus!=0){
                tempPobiBookPagePlus+= tempCrongBookPageForPlus%10;
                tempCrongBookPageForPlus/=10;
            }
        }


        return answer;
    }
}