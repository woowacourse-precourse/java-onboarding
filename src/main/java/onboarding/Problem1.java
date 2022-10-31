package onboarding;

import java.util.List;

/*
    기능 목록
    1. 가장 먼저 예외 케이스 발생을 고려
        -> 책을 임의로 펼쳤을때 왼쪽 페이지 1 or 오른쪽 페이지 400이 나올 경우 예외처리
        -> 왼쪽 페이지와 오른쪽 페이지가 1이상 차이나면 안되기 때문에 예외처리

    2. 왼쪽 페이지와 오른쪽 페이지 각각 더하는 함수, 곱하는 함수를 통해 최고 값을 선정
        -> Math 클래스의 max함수를 사용

    3. pobi와 crong의 최대 점수를 비교해 리턴 값 설정
        -> 삼항 연산자 사용
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiSum, pobiProduct;
        int crongSum, crongProduct;
        int pobiMax = 0;
        int crongMax = 0;

        // Step 1. 예외 케이스 처리
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1
                || pobi.get(0) == 1 || crong.get(1) == 400){
            return -1;
        }

        // Step 2. 최고 값 찾기
        for(int i = 0; i < pobi.size(); i++){
            // sum과 product 함수를 통해 최대 값 찾기
            pobiSum = sum(pobi.get(i));
            crongSum = sum(crong.get(i));
            pobiProduct = product(pobi.get(i));
            crongProduct = product(crong.get(i));

            // Math.max() 함수를 이용하여, 계산 결과에서 가장 큰 값을 선정
            pobiMax = Math.max(pobiMax, Math.max(pobiSum, pobiProduct));
            crongMax = Math.max(crongMax, Math.max(crongSum, crongProduct));
        }

        // Step 3. pobi와 crong의 최대 값 비교 후 answer에 값 저장
        // pobi > crong -> 1
        // pobi == crong -> 0
        // pobi < crong -> 2
        answer = pobiMax > crongMax ? 1 : pobiMax == crongMax ? 0 : 2;

        return answer;
    }

    // input -> 주어진 배열의 값 하나를 받아오는 파라미터
    // tmp라는 char형 배열을 선언해 input 값을 char형 배열로 형변환 하여 대입
    // for-each를 통해 값 누적
    public static int sum(int input){
        char[] tmp = String.valueOf(input).toCharArray();
        int sum = 0;
        for(char value : tmp){
            sum += Integer.parseInt(String.valueOf(value));
        }
        return sum;
    }

    // input -> 주어진 배열의 값 하나를 받아오는 파라미터
    // tmp라는 char형 배열을 선언해 input 값을 char형 배열로 형변환 하여 대입
    // for-each를 통해 값 곱해서 누적
    public static int product(int input){
        char[] tmp = String.valueOf(input).toCharArray();
        int product = 1;
        for(char value : tmp){
            product *= Integer.parseInt(String.valueOf(value));
        }
        return product;
    }
}