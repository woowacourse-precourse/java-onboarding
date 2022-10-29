package onboarding;
import java.util.ArrayList;
import java.util.List;

/**
 * 큰 틀의 기능 구현
 * 1. 입력값 체크 함수 -> number는 1 이상 10,000 이하 범위가 아닌 다른 수 일 때 예외처리
 * 2. 각 숫자를 split을 통해 배열로 만들 함수  ex> 369 -> {3,6,9}
 * 3. 배열을 읽으면서 3,6,9 포함시 int 값 상승 후 그 결과값 return 함수
 * 4. 게임을 시작할 함수
 */

/**
 * 1. 입력값 체크 함수 -> number는 1 이상 10,000 이하 범위가 아닌 다른 수 일 때 예외처리
 * -  예외 일때 return 값을 -1 음수로 부여 true일 때 0
 */

/**
 * 2. 각 숫자를 split을 통해 배열로 만들 함수  ex> 369 -> {3,6,9}
 * - class 변수를 통해 반복적인 메모리 할당량 감소할려고 시도
 * - 순서 바꿔도 상관없다 -> 박수 몇번인지 결과만 알면 되기 때문
 * -
 */

/**
 * 3. 배열을 읽으면서 3,6,9 포함시 int 값 상승 후 그 결과값 return 함수
 */

public class Problem3 {

    static List<Integer> splitNum = new ArrayList<Integer>();
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
//    public static void main(String[] args) {
//        int test = 369;
//        makeSplit(test);
//        System.out.println(splitNum);
//    }
    private static int checkInput(int inputNum){
        if(inputNum < 1 || inputNum > 10000)
            return -1;
        return 0;
    }
    private static void makeSplit(int inputNum){
        splitNum.clear();
        int num = inputNum;
        while(num != 0){
            splitNum.add(num % 10);
            num = num / 10;
        }
    }
    private static int checkClap(){
        int ret = 0;
        for(int i = 0; i < splitNum.size();i++){
            if(splitNum.get(i) == 3 || splitNum.get(i) == 6 || splitNum.get(i) == 9)
                ret++;
        }
        return ret;
    }


}
