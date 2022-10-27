package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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