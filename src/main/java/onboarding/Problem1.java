package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * 1. 책을 임의로 펼친다.
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) { //책을 임의로 펼친다.
        int answer = Integer.MAX_VALUE;
        // 페이지 에러 체크
        int error = page(pobi, crong);
        if(error != -1){
            return answer = -1;
        }
        //포비의 페이지 수 더한 결과
        int pobiAddNum = Stream.of(String.valueOf(pobi.get(0)).split("")).mapToInt(Integer::parseInt).sum();
        int pobiAddNum2 = Stream.of(String.valueOf(pobi.get(1)).split("")).mapToInt(Integer::parseInt).sum();

        // 포비의 페이지 수 곱한 결과
        int pobiMultiply = multiply(Stream.of(String.valueOf(pobi.get(0)).split("")).mapToInt(Integer::parseInt).toArray());
        int pobiMultiply2 = multiply(Stream.of(String.valueOf(pobi.get(1)).split("")).mapToInt(Integer::parseInt).toArray());
        int pobiMaxPage = maxPage(maxPage(pobiAddNum, pobiAddNum2), maxPage(pobiMultiply,pobiMultiply2));

        //크롱의 페이지 수 더한 결과
        int crongAddNum = Stream.of(String.valueOf(crong.get(0)).split("")).mapToInt(Integer::parseInt).sum();
        int crongAddNum2 = Stream.of(String.valueOf(crong.get(1)).split("")).mapToInt(Integer::parseInt).sum();

        //크롱의 페이지 수 곱하기
        int crongMultiply = multiply(Stream.of(String.valueOf(crong.get(0)).split("")).mapToInt(Integer::parseInt).toArray());
        int crongMultiply2 = multiply(Stream.of(String.valueOf(crong.get(1)).split("")).mapToInt(Integer::parseInt).toArray());
        int crongMaxPage = maxPage(maxPage(crongAddNum, crongAddNum2), maxPage(crongMultiply,crongMultiply2));


        if(pobiMaxPage > crongMaxPage){
            return answer = 1;
        }else if(pobiMaxPage > crongMaxPage){
            return answer =2;
        }else{
            return answer =0;
        }
    }

    //페이지 에러 체크 메서드
    public static int page(List<Integer> pobi, List<Integer>  crong){
        if(pobi.get(0) == 0 || crong.get(0) ==0){
            return -2; // 첫 번째 페이지가 규칙에 위반
        }

        if(pobi.get(1)==400 || crong.get(1) ==400){
            return -3; // 두 번째 페이지 규칙 위반
        }

        int value=0;
        for (int x: pobi) {
            if(value <= 0){
                value = x;
            }
            else {
                value -= x;
            }
        }

        if(value < -1){
            return -4;
        }

        return value;
    }

    // 값을 곱하는 메서드
    public static int multiply(int[] value){
        int num=1;
        for (int i: value ) {
            num *= i;
        }

        return num;
    }

    //큰 페이지를 찾는 메서드
    public static int maxPage(int x, int y){
        if(x>y) {
            return x;
        }else{
            return y;
        }
    }
}

