package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 예외사항 작성
        if ( pobiLeftPage < 3 || crongLeftPage < 3 || pobiLeftPage > 397 || crongLeftPage > 397 ) {
            return -1;
        } else if ( pobiRightPage != pobiLeftPage + 1 || crongRightPage != crongLeftPage + 1) {
            return -1;
        } else if ( pobiRightPage%2 != 0 || crongRightPage%2 != 0 ) {
            return -1;
        } else if ( pobi.size() != 2 || crong.size() != 2 ){
            return -1;
        }

        // pobi와 crong 페이지 값에 따른 최대 값 계산
        ArrayList<Integer> arrNumPobiLeft = new ArrayList<>();
        ArrayList<Integer> arrNumPobiRight = new ArrayList<>();
        ArrayList<Integer> arrNumCrongLeft = new ArrayList<>();
        ArrayList<Integer> arrNumCrongRight = new ArrayList<>();

        // While문 및 나누셈을 통한 페이지의 각 자리수 분리하기
        int numPL = pobiLeftPage ;
        int numPR = pobiRightPage ;
        int numCL = crongLeftPage ;
        int numCR = crongRightPage ;

        while ( numPL > 0 ) {
            arrNumPobiLeft.add(numPL%10);
            numPL /= 10;
        }
        int lenghtPL = arrNumPobiLeft.size();
        int sumPL = 0;
        int productPL = 1;

        while ( lenghtPL > 0 ) {
            sumPL += arrNumPobiLeft.get(lenghtPL - 1);
            productPL *= arrNumPobiLeft.get(lenghtPL - 1);
            lenghtPL -= 1;
        }


        while ( numPR > 0 ) {
            arrNumPobiRight.add(numPR%10);
            numPR /= 10;
        }
        int lenghtPR = arrNumPobiRight.size();
        int sumPR = 0;
        int productPR = 1;

        while ( lenghtPR > 0 ) {
            sumPR += arrNumPobiRight.get(lenghtPR - 1);
            productPR *= arrNumPobiRight.get(lenghtPR - 1);
            lenghtPR -= 1;
        }

        while ( numCL > 0 ) {
            arrNumCrongLeft.add(numCL%10);
            numCL /= 10;
        }
        int lenghtCL = arrNumCrongLeft.size();
        int sumCL = 0;
        int productCL = 1;

        while ( lenghtCL > 0 ) {
            sumCL += arrNumCrongLeft.get(lenghtCL - 1);
            productCL *= arrNumCrongLeft.get(lenghtCL - 1);
            lenghtCL -= 1;
        }

        while ( numCR > 0 ) { //numCR(CrongRight)은 페이지 값
            arrNumCrongRight.add(numCR%10); //페이지 값을 10으로 나눠 나머지 값을 CrongRight라는 배열에 순서대로 저장
            numCR /= 10; //페이지 값을 10으로 나눈 후 나머지를 버린 값
        }
        int lenghtCR = arrNumCrongRight.size();
        int sumCR = 0;
        int productCR = 1;

        while ( lenghtCR > 0 ) {
            sumCR += arrNumCrongRight.get(lenghtCR - 1);
            productCR *= arrNumCrongRight.get(lenghtCR - 1);
            lenghtCR -= 1;
        }

        if (Math.max(Math.max(sumPR, productPR), Math.max(sumPL, productPL)) > Math.max(Math.max(sumCR, productCR), Math.max(sumCL, productCL))){
            return 1;
        } else if (Math.max(Math.max(sumPR, productPR), Math.max(sumPL, productPL)) < Math.max(Math.max(sumCR, productCR), Math.max(sumCL, productCL))) {
            return 2;
        }


        return 0;
    }

    //수정해야하는 부분 1) return 값을 answer로 받아오는 (처음 있는 그대로로), 2) 더 간단하게 코딩할 수 없는지

}