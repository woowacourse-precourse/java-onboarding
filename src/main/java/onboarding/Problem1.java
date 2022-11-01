package onboarding;
import java.util.List;
class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION = -1;
    private static final int INTERVAL = 1;

    public static int getMax(List<Integer> bbororo){
        int leftSum = add(bbororo.get(0));
        int rightSum = add(bbororo.get(1));
        int leftProduct = multiply(bbororo.get(0));
        int rightProduct = multiply(bbororo.get(1));

        int leftMax = Math.max(leftSum, leftProduct);
        int rightMax = Math.max(rightSum, rightProduct);

        return Math.max(leftMax, rightMax);
    }

    public static int add(int page){
        int sum = 0;
        while(page > 0){
            int n = page % 10;
            sum += n;
            page /= 10;
        }
        return sum;
    }
    public static int multiply(int page){
        int multi = 1;
        while(page > 0){
            int n = page % 10;
            multi *= n;
            page /= 10;
        }
        return multi;
    }

    public static boolean checkValidity(List<Integer> bbororo){
        int leftPage;
        int rightPage;

        leftPage = bbororo.get(0);
        rightPage = bbororo.get(1);
        return checkInterval(leftPage, rightPage);
    }
    public static boolean checkInterval(int leftPage, int rightPage){
        return (rightPage - leftPage == INTERVAL);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean isValidInput = checkValidity(pobi) && checkValidity(crong);

        if(isValidInput){
            int pobiMax = getMax(pobi);
            int crongMax = getMax(crong);
            if(pobiMax > crongMax){
                answer = POBI_WIN;
            }
            if(pobiMax < crongMax){
                answer = CRONG_WIN;
            }
            if(pobiMax == crongMax){
                answer = TIE;
            }
        }

        if(!checkValidity(pobi)||!checkValidity(crong)){
            answer = EXCEPTION;
        }

        return answer;
    }
}