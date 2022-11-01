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

        // pobi와 crong 페이지의 각 자리수들을 저장해줄 List 정의
        ArrayList<Integer> arrayPobiDigit = new ArrayList<>();
        ArrayList<Integer> arrayCrongDigit = new ArrayList<>();


        int pobiMax = 0;
        int crongMax = 0;


        if (pobiRightPageNumber%10 == 0) { //십의 자리수 혹은 백의 자리수가 바뀔 때는 '왼쪽 페이지의 자릿수 곱 혹은 덧셈'이 항상 더 큰 것을 활용

            while ( pobiLeftPageNumber > 0 ) {
                arrayPobiDigit.add(pobiLeftPageNumber%10);
                pobiLeftPageNumber /= 10;
            }
            int lenghtPL = arrayPobiDigit.size();
            int sumPL = 0;
            int productPL = 1;

            while ( lenghtPL > 0 ) {
                sumPL += arrayPobiDigit.get(lenghtPL - 1);
                productPL *= arrayPobiDigit.get(lenghtPL - 1);
                lenghtPL -= 1;
            }

            pobiMax = Math.max(sumPL, productPL);

        } else if (pobiRightPageNumber%10 != 0) {

            while ( pobiRightPageNumber > 0 ) {
                arrayPobiDigit.add(pobiRightPageNumber%10);
                pobiRightPageNumber /= 10;
            }
            int lenghtPR = arrayPobiDigit.size();
            int sumPR = 0;
            int productPR = 1;

            while ( lenghtPR > 0 ) {
                sumPR += arrayPobiDigit.get(lenghtPR - 1);
                productPR *= arrayPobiDigit.get(lenghtPR - 1);
                lenghtPR -= 1;
            }

            pobiMax = Math.max(sumPR, productPR);

        }

        if (crongRightPageNumber%10 == 0) {
            while ( crongLeftPageNumber > 0 ) {
                arrayCrongDigit.add(crongLeftPageNumber%10);
                crongLeftPageNumber /= 10;
            }
            int lenghtCL = arrayCrongDigit.size();
            int sumCL = 0;
            int productCL = 1;

            while ( lenghtCL > 0 ) {
                sumCL += arrayCrongDigit.get(lenghtCL - 1);
                productCL *= arrayCrongDigit.get(lenghtCL - 1);
                lenghtCL -= 1;
            }

            crongMax = Math.max(sumCL, productCL);


        } else if (crongRightPageNumber%10 != 0) {

            while ( crongRightPageNumber > 0 ) {
                arrayCrongDigit.add(crongRightPageNumber%10);
                crongRightPageNumber /= 10;
            }
            int lenghtCR = arrayCrongDigit.size();
            int sumCR = 0;
            int productCR = 1;

            while ( lenghtCR > 0 ) {
                sumCR += arrayCrongDigit.get(lenghtCR - 1);
                productCR *= arrayCrongDigit.get(lenghtCR - 1);
                lenghtCR -= 1;
            }
            crongMax = Math.max(sumCR, productCR);
        }



        if ( pobiMax > crongMax ){
            return 1;
        } else if (pobiMax < crongMax ) {
            return 2;
        } else if (pobiMax == crongMax) {
            return 0;
        }
        return -1;
    }


}