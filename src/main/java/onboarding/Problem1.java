package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer ;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 예외사항 작성
        if ( pobiLeftPage < 3 || crongLeftPage < 3 || pobiLeftPage > 397 || crongLeftPage > 397 ) { //첫페이지와 마지막 페이지를 안 펼치도록
            return -1;
        } else if ( pobiRightPage != pobiLeftPage + 1 || crongRightPage != crongLeftPage + 1) { //왼쪽 페이지와 오른쪽 페이지가 1만큼 차이난다는 의존성
            return -1;
        } else if ( pobiRightPage%2 != 0 || crongRightPage%2 != 0 ) { //오른쪽 페이지가 짝수인지 확인
            return -1;
        } else if ( pobi.size() != 2 || crong.size() != 2 ){ //받아오는 list의 size가 2개가 아닌지 확인
            return -1;
        }

        // pobi와 crong 페이지의 각 자리수들을 저장해줄 List 정의
        ArrayList<Integer> arrayPobiDigit = new ArrayList<>();
        ArrayList<Integer> arrayCrongDigit = new ArrayList<>();


        int pobiMax = 0;
        int crongMax = 0;


        if (pobiRightPage%10 == 0) { //십의 자리수 혹은 백의 자리수가 바뀔 때는 '왼쪽 페이지의 자릿수 곱 혹은 덧셈'이 항상 더 큰 것을 활용

            while ( pobiLeftPage > 0 ) {
                arrayPobiDigit.add(pobiLeftPage%10);
                pobiLeftPage /= 10;
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

        } else if (pobiRightPage%10 != 0) {

            while ( pobiRightPage > 0 ) {
                arrayPobiDigit.add(pobiRightPage%10);
                pobiRightPage /= 10;
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

        if (crongRightPage%10 == 0) {
            while ( crongRightPage > 0 ) {
                arrayCrongDigit.add(crongRightPage%10);
                crongRightPage /= 10;
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


        } else if (crongRightPage%10 != 0) {

            while ( crongRightPage > 0 ) {
                arrayCrongDigit.add(crongRightPage%10);
                crongRightPage /= 10;
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