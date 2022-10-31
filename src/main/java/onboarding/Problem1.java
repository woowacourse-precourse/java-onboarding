package onboarding;

import java.util.List;

/*
* 기능 구현 사항
* 1. 왼쪽,오른쪽 페이지의 결과값 계산
* 2. 왼쪽,오른쪽 페이지의 결과값 비교후 큰 값 반환
* 3. 크롱과 포비의 결과값 비교후 반환
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //페이지의 사이즈가 2가 아니라면 예외사항
        if(pobi.size() != 2 || crong.size() != 2){
            return -1;
        }

        int pobiResult = 0;
        int crongResult = 0;
        int compareResult = 0;

        //pobi의 결과값
        pobiResult = comparePageNum(pobi);

        //crong의 결과값
        crongResult = comparePageNum(crong);

        //pobi,crong 둘중한명의 결과값이 이상할경우 -1 반환
        if(pobiResult == -1 || crongResult == -1){
            return -1;
        }

        //크롱과 포비의 결과값 비교
        compareResult = Integer.compare(pobiResult,crongResult);

        if(compareResult == 1){     //포비가 이긴경우
            answer = 1;
        }else if(compareResult == 0){   //무승부인경우
            answer = 0;
        }else{                      //크롱이 이긴경우
            answer = 2 ;
        }

        return answer;
    }

    // 왼쪽,오른쪽 페이지의 결과값 비교
    public static int comparePageNum(List<Integer> pageList){
        //각 페이지의 왼쪽페이지값 , 오른쪽 페이지 값
        int left = pageList.get(0);
        int right = pageList.get(1);

        //왼쪽페이지와 오른쪽페이지의 번호차이가 1이 아니라면 예외사항
        if(right - left != 1){
            return -1;
        }

        if(right < 3 || right > 400){
            return -1;
        }
        if(left < 2 || left > 399){
            return -1;
        }

        left = addOrMultiplicationNum(left);
        right = addOrMultiplicationNum(right);

        int result = Integer.compare(left,right);

        if(result == 1){            //왼쪽페이지의 결과값이 더 큼
            return left;
        }else if(result == -1){     //오른쪽페이지의 결과값이 더 큼
            return right;
        }else{
            return left;            //왼쪽,오른쪽 페이지의 결과값이 같음
        }
    }

    //각 페이지의 결과값 계산
    public static int addOrMultiplicationNum(int num){
        int addNum = 0;
        int multiplicationNum = 1;      //각 자리수 곱셈을 위해 1로 변수할당

        String stringNum = Integer.toString(num);

        //숫자의 자릿수
        int digit = stringNum.length();

        //각 자리수 더하기
        for(int i = 0; i < digit ; i++){
            addNum += stringNum.charAt(i) - '0';
        }

        //각 자리수 곱하기
        for(int i = 0 ; i < digit ; i++){
            multiplicationNum *= stringNum.charAt(i) - '0';
        }

        int result = Integer.compare(addNum,multiplicationNum);

        if(result == 1){        //각 자리수 덧셈결과가 더 클경우
            return addNum;
        }else if(result == -1){ //각 자리수 곱셈결과가 더 클경우
            return multiplicationNum;
        }else{                  // 각 자리수 덧셈,곱셈 결과가 같은 경우
            return addNum;
        }
    }
}