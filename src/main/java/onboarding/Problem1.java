package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobiRight = pobi.get(0);
        int pobiLeft = pobi.get(1);
        int crongRight = crong.get(0);
        int crongLeft = crong.get(1);

//        예외처리 : 페이지가 맨 앞이나 뒤일 경우, 좌우 페이지 번호 차가 1이 아닌 경우
        if(pobiRight == 1 || pobiRight == 399 ){return -1;}
        else if (crongRight == 1 || crongRight == 399) {return -1;
        }else if (Math.abs(pobiRight-pobiLeft)!=1 || Math.abs(crongRight-crongLeft)!=1 ) {return -1;}


        int pobiLargest = getBigger(pobi);
        int crongLargest = getBigger(crong);

        if(pobiLargest == crongLargest){answer= 0;}else if(pobiLargest>crongLargest){answer= 1;} else {
            answer= 2;

        }

        return answer;
    }


// 좌,우 페이지 번호의 자릿수를 모두 더하거나 곱한 수에서 가장 큰 수를 반환
    public static int getBigger(List<Integer> pages){
        String rightPage = Integer.toString(pages.get(0));
        String leftPage = Integer.toString(pages.get(1));

        int rightPageLargest = Math.max(addDigits(rightPage),multiplyDigits(rightPage));
        int leftPageLargest = Math.max(addDigits(leftPage),multiplyDigits(leftPage));


        return Math.max(rightPageLargest,leftPageLargest);

    }

//각 자릿수 더하기
    public static int addDigits(String page){
        int sum = 0;

        for(int i=0; i<page.length(); i++){
            sum += Integer.parseInt(page.substring(i, i+1));
        }
        return sum;
    }
//각 자릿수 곱하기
    public static int multiplyDigits(String page){
        int sum = 1;

        for(int i=0; i<page.length(); i++){
            sum *= Integer.parseInt(page.substring(i, i+1));
        }
        return sum;
    }


}