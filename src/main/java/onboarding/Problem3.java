package onboarding;

/*
firstProcess(), secondProcess(), thirdProcess(), fourthProcess()
=> docs/PROBLEM3.md의 기능정리 - "0. 공식 정리" - "공식2. 1부터 number까지 3, 6, 9 개수 도출 과정" 참고
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Problem3 problem3 = new Problem3();

        try {
            if (number < 1 || 10000 < number) {
                throw new Exception("Input Number is out of range.");
            }

            answer = problem3.countClap(number);

            return answer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int countClap(int number) {
        int inputNumber = number;
        int countOfTotalClap = 0;

        for (int i = 4; i > 0; i--) {
            if (inputNumber >= Math.pow(10, i)) {
                int digitNumber = (int)(inputNumber / Math.pow(10, i));

                countOfTotalClap += firstProcess(i, digitNumber);

                countOfTotalClap += secondProcess(i, digitNumber);

                countOfTotalClap += thirdProcess(i, digitNumber, inputNumber);

                inputNumber = (int)(inputNumber % Math.pow(10, i));
            }
        }

        countOfTotalClap += fourthProcess(inputNumber);

        return countOfTotalClap;
    }

    public int firstProcess(int indexOfTen, int digitNumber) {
        int countOfFirstProcess = 0;

        for (int i = 0; i < indexOfTen; i++) {
            countOfFirstProcess += digitNumber*3*Math.pow(10, indexOfTen-1);
        }

        return countOfFirstProcess;
    }

    public int secondProcess(int indexOfTen, int digitNumber) {
        int countOfSecondProcess = 0;

        countOfSecondProcess += ((digitNumber-1)/3)*Math.pow(10,indexOfTen);

        return countOfSecondProcess;
    }

    public int thirdProcess(int indexOfTen, int digitNumber, int number) {
        int countOfThirdProcess = 0;

        if ((digitNumber % 3) == 0) {
            countOfThirdProcess += (int)(number % Math.pow(10, indexOfTen)) + 1;
        }

        return countOfThirdProcess;
    }

    public int fourthProcess(int digitNumberOfOne) {
        int countOfFourthProcess = 0;

        countOfFourthProcess += (digitNumberOfOne / 3);

        return countOfFourthProcess;
    }
}
