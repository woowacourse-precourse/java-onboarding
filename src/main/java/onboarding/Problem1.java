package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 왼쪽, 오른쪽 페이지에서 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxPageNumber(ArrayList<Integer> array) {
        int max = 0;

        for (int i = 0; i < array.size(); i++) {
            int pageNumber = maxNumber(array.get(i));

            if (pageNumber > max) {
                max = pageNumber;
            }
        }

        return max;
    }


    // 페이지의 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxNumber(int number) {

        int sum = add(number);
        int multiplication = multiply(number);

        return Math.max(sum, multiplication);

    }

    // 페이지의 각 자리 숫자를 모두 곱하는 메소드
    private static int multiply(int number) {
        int multiplication = 1;
        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            multiplication *= num.charAt(i);
        }

        return multiplication;
    }


    // 페이지의 각 자리 숫자를 모두 더하는 메소드
    private static int add(int number) {
        int sum =0;
        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i);
        }

        return sum;
    }


    // 랜덤한 왼쪽, 오른쪽 페이지 숫자를 반환하는 메소드
    private static ArrayList<Integer> randomNumbers () {
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        int randomNumber = randomNumber();

        if (randomNumber % 2 == 0) {  // 짝수라면, 배열에 홀수를 먼저 추가
            randomNumbers.add(randomNumber - 1);
            randomNumbers.add(randomNumber);
        }

        if (randomNumber % 2 != 0) { // 홀수라면, 배열에 짝수를 뒤에 추가
            randomNumbers.add(randomNumber);
            randomNumbers.add(randomNumber + 1);
        }

        return randomNumbers;
    }


    // 3~398 사이의 랜덤 숫자를 반환하는 메소드
    private static int randomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt();

        while (!isInBookPage(randomNumber)) {
            randomNumber = random.nextInt();
        }
        return randomNumber;
    }


    // 매개변수가 책 페이지 범위 안에 있는지 체크하는 메서드
    private static boolean isInBookPage(int number) {
        return number >= 3 && number <= 398;
    }

}