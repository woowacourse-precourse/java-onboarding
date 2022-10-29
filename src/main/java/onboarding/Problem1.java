package onboarding;

import java.util.List;
import java.util.Iterator;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        /*
        책을 임의로 펼친다.
        왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다
         */

        // 민약 페이지의 값이 왼쪽 오른쪽이 차이가 1이 나지 않거나, 홀수 , 짝수가 아니면 예외처리
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            answer = -1;
        }
        else if (pobi.get(1)%2!=0 || pobi.get(0) %2 ==0 ||  crong.get(1)%2!=0 || crong.get(0) %2 ==0){
            answer = -1;
        }

        else if (pobi.get(0)==0 || pobi.get(1) ==400 ||  crong.get(0)==0 || crong.get(1)==400){
            answer = -1;
        }
        else if (pobi.get(1)==0 || pobi.get(0) ==400 ||  crong.get(1)==0 || crong.get(0)  ==400){
            answer = -1;
        }
        else {
            // pobi 와 crong이 계산했을 때 가장 큰 페이지 연산 결과를 저장할 변수
            int pobiFinalBookPageNumber = Integer.MIN_VALUE;
            int crongFinalBookPageNumber = Integer.MIN_VALUE;

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

                //pobi 곱셈 연산
                while (tempPobiBookPageForMultiple!=0){
                    tempPobiBookPageMultiple*= tempPobiBookPageForMultiple%10;
                    tempPobiBookPageForMultiple/=10;
                }

                //crong 덧셈 연산
                while (tempCrongBookPageForPlus!=0) {
                    tempCrongBookPagePlus += tempCrongBookPageForPlus % 10;
                    tempCrongBookPageForPlus /= 10;
                }

                //crong 곱셈 연산
                while (tempCrongBookPageForMultiple!=0){
                    tempCrongBookPageMultiple*= tempCrongBookPageForMultiple%10;
                    tempCrongBookPageForMultiple/=10;
                }

                // pobi, crong max 값 인지 확인
                if (pobiFinalBookPageNumber < tempPobiBookPagePlus){
                    pobiFinalBookPageNumber = tempPobiBookPagePlus;
                }
                if (pobiFinalBookPageNumber < tempPobiBookPageMultiple){
                    pobiFinalBookPageNumber = tempPobiBookPageMultiple;
                }

                if (crongFinalBookPageNumber < tempCrongBookPagePlus){
                    crongFinalBookPageNumber = tempCrongBookPagePlus;
                }
                if (crongFinalBookPageNumber < tempCrongBookPageMultiple){
                    crongFinalBookPageNumber = tempCrongBookPageMultiple;
                }
            }
            if (pobiFinalBookPageNumber < crongFinalBookPageNumber){
                answer = 2;
            }
            else if (pobiFinalBookPageNumber > crongFinalBookPageNumber){
                answer = 1;
            }

        }


        return answer;
    }
}