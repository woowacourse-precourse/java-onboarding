package onboarding;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class Problem1 {

    public static class Numbers {
        private static final int LEFT = 0;
        private static final int RIGHT = 1;

        private List<Number> numbers;

        public Numbers(List<Number> numbers) {
            validNumbers(numbers);
            this.numbers = numbers;
        }

        private void validNumbers(List<Number> numbers) {
            if (!numbers.get(LEFT).checkLeft() || !numbers.get(RIGHT).checkRight()) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (!numbers.get(LEFT).checkNext(numbers.get(RIGHT))) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        public int getMax() {
            return Math.max(numbers.stream()
                    .mapToInt(number -> number.getSum())
                    .max()
                    .orElseThrow(NoSuchElementException::new), numbers.stream()
                    .mapToInt(number -> number.getMul())
                    .max()
                    .orElseThrow(NoSuchElementException::new));
        }
    }

    public static class Number {
        private Integer value;

        public Number(Integer value) {
            this.value = value;
        }

        public boolean checkLeft() {
            if (value % 2 == 1) {
                return true;
            }
            return false;
        }

        public boolean checkRight() {
            if (value % 2 == 0) {
                return true;
            }
            return false;
        }

        public int getSum() {
            String valueToString = value.toString();
            int result = 0;
            for (int i = 0; i < valueToString.length(); i++) {
                result = result + Integer.parseInt(String.valueOf(valueToString.charAt(i)));
            }
            return result;
        }
        public int getMul() {
            String valueToString = value.toString();
            int result = 1;
            for (int i = 0; i < valueToString.length(); i++) {
                result = result * Integer.parseInt(String.valueOf(valueToString.charAt(i)));
            }
            return result;
        }

        public boolean checkNext(Number number) {
            if (this.value - number.value != -1) {
                return false;
            }
            return true;
        }
    }

    public static class GameController {

        protected GameController(){};

        private static int getPlayerScore(int player1, int player2) {
            if (player1 > player2) {
                return player1;
            }
            return player2;
        }

        public static int getWinner(Numbers player1, Numbers player2) {
            int firstPlayerScore = getPlayerScore(player1.getMax(), player1.getMax());
            int secondPlayerScore = getPlayerScore(player2.getMax(), player2.getMax());
            if (firstPlayerScore > secondPlayerScore) {
                return 1;
            }
            if (firstPlayerScore < secondPlayerScore) {
                return 2;
            }
            return 0;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Numbers pobiNumbers = new Numbers(pobi.stream()
                    .map(value -> new Number(value))
                    .collect(Collectors.toList()));
            Numbers crongNumbers = new Numbers(crong.stream()
                    .map(value -> new Number(value))
                    .collect(Collectors.toList()));
            return GameController.getWinner(pobiNumbers, crongNumbers);
        } catch (Exception e) {
            return -1;
        }
    }
}