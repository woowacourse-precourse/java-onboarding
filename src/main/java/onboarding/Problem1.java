package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Problem1 {
    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>(Book.open());
        List<Integer> crong = new ArrayList<>(Book.open());

        System.out.println("pobi = " + pobi.toString());
        System.out.println("crong = " + crong.toString());
        System.out.println("result = " + solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (PageValidator.hasPageException(pobi, crong)) {
            return -1;
        }
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

    private static class PageValidator {
        public static boolean hasPageException(List<Integer> pobiPages, List<Integer> crongPages) {
            if (checkPageLength(pobiPages) || checkPageLength(crongPages)) {
                return true;
            }
            if (checkPageOrder(pobiPages) || checkPageOrder(crongPages)) {
                return true;
            }
            return false;
        }

        private static boolean checkPageLength(List<Integer> pages) {
            return pages.size() != 2;
        }

        private static boolean checkPageOrder(List<Integer> pages) {
            int leftPage = pages.get(0);
            int rightPage = pages.get(1);

            if (leftPage > rightPage) {
                return true;
            }
            if (leftPage % 2 != 1) {
                return true;
            }
            if (rightPage % 2 != 0) {
                return true;
            }
            if (rightPage - leftPage != 1) {
                return true;
            }
            return false;
        }
    }

    private static int compareUserScore(List<Integer> pobiPages, List<Integer> crongPages) {
        int pobiScore = findScore(pobiPages);
        int crongScore = findScore(crongPages);

        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int findScore(List<Integer> pages) {
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

    private static class Book {
        private static final int END_PAGE = 400;

        public static List<Integer> open() {
            List<Integer> pages = new ArrayList<>();
            pages.add((int) (Math.random() * (END_PAGE - 1) / 2) * 2 + 1);
            pages.add(pages.get(0) + 1);
            return pages;
        }
    }
}