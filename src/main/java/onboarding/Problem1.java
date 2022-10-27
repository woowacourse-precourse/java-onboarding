package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 페이지의 타당성 확인
        if(checkPageCorrect(pobiLeftPage, pobiRightPage) && checkPageCorrect(crongLeftPage, crongRightPage)){
            //포비의 책페이지중 최댓값, 크롱의 책페이지 중 최댓값 선언
            int pobiMax= Math.max(CompareMultAndAdd(pobiLeftPage), CompareMultAndAdd(pobiRightPage));
            int crongMax= Math.max(CompareMultAndAdd(crongLeftPage), CompareMultAndAdd(crongRightPage));
            //미션 결과 리턴
            if(pobiMax>crongMax){
                return 1;
            }else if(pobiMax<crongMax){
                return 2;
            }else{
                return 0;
            }
        }else{
            return (-1);
        }




    }

    //페이지의 타당성 확인 함수
    static boolean checkPageCorrect(int leftPage, int rightPage) {
        return ((leftPage>1 && rightPage<400) && (rightPage-leftPage==1) && (leftPage % 2 ==1));
    }

    // 정수를 넣었을 때 각 자리를 배열로 리턴해주는 함수
    static int[] makeNumToArray(int number){
        String string = Integer.toString(number);
        int [] array = new int[string.length()];
        for (int i=0; i<string.length(); i++ ){
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }
    //makeNumToArray를 사용하여 더한수와 곱한수중 최댓값을 리턴해주는 함수
    static int CompareMultAndAdd(int pageNum){
        int sumNum=0;
        int mulNum=1;
        int [] arr= makeNumToArray(pageNum);

        for(int i=0; i<makeNumToArray(pageNum).length;i++ ){
            sumNum += arr[i];
            mulNum *= arr[i];
        };
        return Math.max(sumNum, mulNum);
    }



}