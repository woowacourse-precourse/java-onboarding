package onboarding;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    /**
     *
     * Solution.
     * Exception check 후 계산을 진행.
     * @param pobi pobi input
     * @param crong crong input
     * @return answer
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 포비 또는 크롱의 page에 문제가 있다면 -1 반환
        if(exceptionChecker(pobi) || exceptionChecker(crong))
            answer = -1;
        else{
            // page에 문제가 없는 경우 포비와 크론의 점수를 계산
            int pobiScore = calculatePersonalScore(pobi);
            int cronScore = calculatePersonalScore(crong);

            if(pobiScore > cronScore)
                answer = 1;
            else if(pobiScore < cronScore)
                answer = 2;
            else
                answer = 0;
        }
        return answer;
    }

    /**
     *
     * @param page 검사하고 싶은 페이지
     * @return 예외가 발생하면 true, 아니라면 false를 반환
     */
    private static boolean exceptionChecker(List<Integer> page){
        // 1. page의 size 2가 아닌 경우
        if(page.size()!= 2)
            return true;
        // 2. 1부터 400 사이 값이 아닌 경우
        if(!isBetween(1,400,page.get(0)) || !isBetween(1,400,page.get(1)))
            return true;
        // 3. 왼쪽은 홀수 오른쪽은 짝수가 아닌 경우
        if(!isOdd(page.get(0)) || !isEven(page.get(1)))
            return true;
        // 4. 오른쪽 - 왼쪽이 1이 아닌 경우
        if(!isBookPage(page))
            return true;

        return false;
    }

    /**
     *
     * @param number 검사 하고 싶은 숫자
     * @return 홀수 여부를 판단하여 boolean 값을 반환
     */
    private static boolean isOdd(int number){
        if(number % 2 == 1)
            return true;
        else
            return false;
    }

    /**
     *
     * @param number 검사 하고 싶은 숫자
     * @return 짝수 여부를 판단하여 boolean 값을 반환
     */
    private static boolean isEven(int number){
        if(number%2 == 0)
            return true;
        else
            return false;
    }

    /**
     *
     * @param page 검사하고 싶은 page (legnth = 2)
     * @return 책 페이지인지 검사하여 boolean return
     */
    private static boolean isBookPage(List<Integer> page){
        if(page.get(1)-page.get(0) == 1)
            return true;
        else
            return false;
    }


    /**
     *
     * Target이 min 이상 max 이하에 있는 값인지 검사
     * @param min 검사하고 싶은 범위 중 작은 값
     * @param max 검사하고 싶은 범위 중 큰 값
     * @param target 검사하고 싶은 값
     * @return 사이에 존재한다면 true, 아니라면 false를 반환
     */
    private static boolean isBetween(int min, int max, int target){
        if(min<=target && target<=max)
            return true;
        else
            return false;
    }

    /**
     *
     * 페이지의 왼쪽 값과 오른쪽 값을 계산 후 큰 값을 반환
     * @param page
     * @return 개인 점수
     */
    private static int calculatePersonalScore(List<Integer> page){
        int left = calculateSingePageScore(page.get(0));
        int right = calculateSingePageScore(page.get(1));

        if(left > right)
            return left;
        else
            return right;
    }

    /**
     *
     * 한 쪽 페이지의 점수를 계산
     * 곱, 합을 계산하여 그 중 더 큰 것을 반환
     * @param number 계산하고 싶은 한 쪽 숫자
     * @return 한 쪽 페이지의 점수
     */
    private static int calculateSingePageScore(int number){
        // 토큰화
        int[] tokenizedNumber = tokenize(number);

        // init
        int product = tokenizedNumber[0];
        int plus = tokenizedNumber[0];

        // 모든 자리수를 더한 값과 곱한 값을 계산
        for(int i = 1; i < tokenizedNumber.length; i++){
            product = product * tokenizedNumber[i];
            plus = plus + tokenizedNumber[i];
        }

        // 더 큰 값을 반환
        if(product > plus)
            return product;
        else
            return plus;
    }

    /**
     *
     * @param number target 숫자
     * @return 들어온 숫자를 토큰화 하여 int 배열을 반환
     */
    private static int[] tokenize(int number){
        String stringifyNumber = Integer.toString(number,10);

        String[] strArray = stringifyNumber.split("");

        int[] intArray = Arrays.stream(strArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        return intArray;
    }
}