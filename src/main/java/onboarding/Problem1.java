package onboarding;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, compareUserScore(pobi, crong));
        return answer;
    }

    static class PlaceValue {
        private final int units;
        private final int tens;
        private final int hundreds;

        public PlaceValue(int page) {
            this.units = page % 10;
            this.tens = page % 100 / 10;
            this.hundreds = page / 100;
        }

        public int multiplyPlaceValue() {
            if (hundreds > 0) {
                return hundreds * tens * units;
            } else if (tens > 0) {
                return tens * units;
            }
            return units;
        }

        public int addPlaceValue() {
            return hundreds + tens + units;
        }
    }

    private static int compareUserScore(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int getScore(List<Integer> pages) {
        Optional<Integer> score = pages.stream().map(page -> {
                PlaceValue placeValue = new PlaceValue(page);
                return compareNumber(placeValue.addPlaceValue(), placeValue.multiplyPlaceValue());
            }
        ).sorted(Comparator.reverseOrder()).findAny();
        return score.orElse(0);
    }

    private static int compareNumber(int addPlaceValue, int multiplyPlaceValue) {
        return Math.max(addPlaceValue, multiplyPlaceValue);
    }
}