package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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
}
