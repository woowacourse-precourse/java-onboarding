package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int answerOfPoi, answerOfCrong;

        // 예외 사항 처리
        if(!(isValidBookPage(pobi) && isValidBookPage(crong)))
            return -1;

        answerOfPoi = getBiggestNumber(pobi);
        answerOfCrong = getBiggestNumber(crong);

        return answer;
    }
    static boolean isValidBookPage(List<Integer> person) {
        boolean isLeftOddNumber = (person.get(0) % 2) == 1;
        boolean isLeftAndRight = (person.get(1) - person.get(0)) == 1;
        boolean isValidBookScope = (person.get(0) >= 1 && person.get(1) <= 400);

        return (isLeftOddNumber && isLeftAndRight && isValidBookScope);
    }

    static int getBiggestNumber(List<Integer> person){
        int answer = 0;

        for(Integer number : person){
            int resultFromMultiplication = multiplyAllNumbers(number);
            int resultFromAddition = addAllNumbers(number);
            int result = Math.max(resultFromMultiplication, resultFromAddition);
            answer = Math.max(answer, result);
        }
        return answer;
    }

    static int multiplyAllNumbers(Integer number){
        int result = 1;
        String s = Integer.toString(number);

        for(int i=0; i<s.length(); i++)
            result *= Integer.parseInt((s.substring(i,i+1)));

        return result;
    }

    static int addAllNumbers(Integer number){
        int sum = 0;
        String s = Integer.toString(number);

        for(int i=0; i<s.length(); i++)
            sum += Integer.parseInt(s.substring(i, i+1));
        return sum;
    }

}