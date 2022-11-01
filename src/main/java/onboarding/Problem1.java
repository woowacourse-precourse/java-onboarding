package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer ;

        int pobiLeftPageNumber = pobi.get(0);
        int pobiRightPageNumber = pobi.get(1);
        int crongLeftPageNumber = crong.get(0);
        int crongRightPageNumber = crong.get(1);

        // 예외사항 작성
        if ( pobiLeftPageNumber < 3 || crongLeftPageNumber < 3 || pobiLeftPageNumber > 397 || crongLeftPageNumber > 397 ) { //첫페이지와 마지막 페이지를 안 펼치도록
            return -1;
        } else if ( pobiRightPageNumber != pobiLeftPageNumber + 1 || crongRightPageNumber != crongLeftPageNumber + 1) { //왼쪽 페이지와 오른쪽 페이지가 1만큼 차이난다는 의존성
            return -1;
        } else if ( pobiRightPageNumber%2 != 0 || crongRightPageNumber%2 != 0 ) { //오른쪽 페이지가 짝수인지 확인
            return -1;
        } else if ( pobi.size() != 2 || crong.size() != 2 ){ //받아오는 list의 size가 2개가 아닌지 확인
            return -1;
        }

        // pobi와 crong 페이지의 각 자리수들의 곱 혹은 합의 최대값 변수 정의

        int pobiMax = 0;
        int crongMax = 0;


        if (pobiRightPageNumber%10 == 0) { //십의 자리수 혹은 백의 자리수가 바뀔 때는 '왼쪽 페이지의 자릿수 곱 혹은 덧셈'이 항상 더 큰 것을 활용

            int sumPL = 0;  //PL은 pobi Left
            int productPL = 1;

            while ( pobiLeftPageNumber > 0 ) { //각 자리수들을 하나씩 분리(일의 자리로 만듦)시킨 후 각 자리수의 합과 곱 구함
                int pobiEachDigitNumber = pobiLeftPageNumber%10;
                sumPL += pobiEachDigitNumber;
                productPL *= pobiEachDigitNumber;
                pobiLeftPageNumber /= 10;
            }

            pobiMax = Math.max(sumPL, productPL); //각 자리수들의 합과 곱을 비교해서 최대 값 찾기

        } else if (pobiRightPageNumber%10 != 0) { //십의 자리수 혹은 백의 자리수가 바뀌지 않을 때는 '오른쪽 페이지의 자릿수 곱 혹은 덧셈'이 항상 더 큰 것을 활용

            int sumPR = 0;  //PR은 pobi Right
            int productPR = 1;

            while ( pobiRightPageNumber > 0 ) { //각 자리수들을 하나씩 분리(일의 자리로 만듦)시킨 후 배열에 저장
                int pobiEachDigitNumber = pobiRightPageNumber%10;
                sumPR += pobiEachDigitNumber;
                productPR *= pobiEachDigitNumber;
                pobiRightPageNumber /= 10;
            }

            pobiMax = Math.max(sumPR, productPR); //각 자리수들의 합과 곱을 비교해서 최대 값 찾기

        }

        if (crongRightPageNumber%10 == 0) {

            int sumCL = 0; //CL은 Crong Left
            int productCL = 1;

            while ( crongLeftPageNumber > 0 ) { //각 자리수들을 하나씩 분리(일의 자리로 만듦)시킨 후 배열에 저장
                int crongEachDigitNumber = crongLeftPageNumber%10;
                sumCL += crongEachDigitNumber;
                productCL *= crongEachDigitNumber;
                crongLeftPageNumber /= 10;
            }

            crongMax = Math.max(sumCL, productCL); //각 자리수들의 합과 곱을 비교해서 최대 값 찾기


        } else if (crongRightPageNumber%10 != 0) {

            int sumCR = 0;//CR은 Crong Right
            int productCR = 1;

            while ( crongRightPageNumber > 0 ) { //각 자리수들을 하나씩 분리(일의 자리로 만듦)시킨 후 배열에 저장
                int crongEachDigitNumber = crongRightPageNumber%10;
                sumCR += crongEachDigitNumber;
                productCR *= crongEachDigitNumber;
                crongRightPageNumber /= 10;
            }

            crongMax = Math.max(sumCR, productCR); //각 자리수들의 합과 곱을 비교해서 최대 값 찾기
        }



        if ( pobiMax > crongMax ){ //pobi와 crong의 최대값들을 비교 후 return
            return 1;
        } else if (pobiMax < crongMax ) {
            return 2;
        } else if (pobiMax == crongMax) {
            return 0;
        }
        return -1;
    }


}