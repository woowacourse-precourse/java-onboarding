package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;

    if( exceptionCaseCheck(pobi) || exceptionCaseCheck(crong)) { // 둘다 예외체크를 통과해야 함
        answer = -1;
        return answer;
    }
    // 예외 체크 통과된 이후에 값 비교
    int pobiMaxNumber = max(addNumbers(pobi),multiNumbers(pobi));
    int crongMaxNumber = max(addNumbers(crong),multiNumbers(crong));

    if(pobiMaxNumber > crongMaxNumber) answer = 1; // pobi wins!
    else if(pobiMaxNumber == crongMaxNumber) answer = 0; // evens!
    else if(pobiMaxNumber < crongMaxNumber) answer = 2; // crong wins!

    return answer;
}

    public static boolean exceptionCaseCheck(List<Integer> List){
        int leftPage = List.get(0);
        int rightPage = List.get(1);

        if((rightPage - leftPage) != 1) return true;
        if(leftPage % 2 != 1 ) return true;
        if(rightPage % 2 != 0 ) return true;

        return false;
    }

    public static int addNumbers(List<Integer> List){
        int leftPage=List.get(0);
        int rightPage=List.get(1);

        int AddedLeftPage = add(leftPage);
        int AddedRightPage = add(rightPage);

        return max(AddedLeftPage,AddedRightPage);
    }
    public static int add(int num){
        int hundredDigitComponent = num / 100;
        int tenDigitComponent = num/10 - (hundredDigitComponent *10);
        int oneDigitComponent = num - (hundredDigitComponent *100 + tenDigitComponent*10);

        return hundredDigitComponent + tenDigitComponent + oneDigitComponent;
    }

    public static int multiNumbers(List<Integer> List){
        int leftPage=List.get(0);
        int rightPage=List.get(1);

        int multipliedLeftPage = multiply(leftPage);
        int multipliedRightPage = multiply(rightPage);

        return max(multipliedLeftPage,multipliedRightPage);
    }

    public static int multiply(int num){
        int hundredDigitComponent = num / 100;
        int tenDigitComponent = num/10 - (hundredDigitComponent *10);
        int oneDigitComponent = num - (hundredDigitComponent *100 + tenDigitComponent*10);

        if(num >= 100) return hundredDigitComponent * tenDigitComponent * oneDigitComponent;
        else if (num <100 && num >= 10) return tenDigitComponent * oneDigitComponent;
        else  return oneDigitComponent; // num < 10
    }

    public static int max(int a, int b){
        if(a > b) return a;
        else return b;
    }


}
