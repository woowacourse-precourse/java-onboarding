package onboarding;

import java.util.*;

class Problem1 {
    static int pobiMaxScore;
    static int crongMaxScore;
    static int gemaResult;
    static List<Integer> pobiScore = new ArrayList<>();
    static List<Integer> crongScore = new ArrayList<>();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!pageException(pobi, crong)) {
            gemaResult = -1;
        }
        if (pageException(pobi, crong)) {
            maxScore(pobi, crong);
            gemaResult = compareMaxScore();
        }
        return gemaResult;
    }

    public static void maxScore(List<Integer> pobi, List<Integer> crong) {
        pobiAddition(pobi);
        pobiMultiplication(pobi);
        crongAddition(crong);
        crongMultiplication(crong);

        pobiMaxScore = Collections.max(pobiScore);
        crongMaxScore = Collections.max(crongScore);

        pobiScore.clear();
        crongScore.clear();
    }

    public static int compareMaxScore() {
        if (pobiMaxScore > crongMaxScore) {
            return 1;
        }
        if (pobiMaxScore < crongMaxScore) {
            return 2;
        }
        if (pobiMaxScore == crongMaxScore) {
            return 0;
        }
        return -1;
    }

    public static void pobiAddition(List<Integer> pobi) {
        for (int pobiPageNumber : pobi) {
            int result = 0;
            for (int i = 0; i < pobiPageNumber; i++) {
                result += pobiPageNumber % 10;
                pobiPageNumber /= 10;
                if (pobiPageNumber < 10) {
                    result += pobiPageNumber;
                    break;
                }
            }
            pobiScore.add(result);
        }
    }

    public static void pobiMultiplication(List<Integer> pobi) {
        for (int pobiPageNumber : pobi) {
            int result = 1;
            for (int i = 0; i < pobiPageNumber; i++) {
                result *= pobiPageNumber % 10;
                pobiPageNumber /= 10;
                if (pobiPageNumber < 10) {
                    result *= pobiPageNumber;
                    break;
                }
            }
            pobiScore.add(result);
        }
    }

    public static void crongAddition(List<Integer> crong) {
        for (int crongPageNumber : crong) {
            int result = 0;
            for (int i = 0; i < crongPageNumber; i++) {
                result += crongPageNumber % 10;
                crongPageNumber /= 10;
                if (crongPageNumber < 10) {
                    result += crongPageNumber;
                    break;
                }
            }
            crongScore.add(result);
        }
    }

    public static void crongMultiplication(List<Integer> crong) {
        for (int crongPageNumber : crong) {
            int result = 1;
            for (int i = 0; i < crongPageNumber; i++) {
                result *= crongPageNumber % 10;
                crongPageNumber /= 10;
                if (crongPageNumber < 10) {
                    result *= crongPageNumber;
                    break;
                }
            }
            crongScore.add(result);
        }
    }

    public static boolean pageException(List<Integer> pobi, List<Integer> crong) {
        int pobiRightPage = pobi.get(1);
        int pobiLeftPage = pobi.get(0);
        if (pobiRightPage - pobiLeftPage != 1) {
            return false;
        }

        int crongRightPage = crong.get(1);
        int crongLeftPage = crong.get(0);
        if (crongRightPage - crongLeftPage != 1) {
            return false;
        }
        return true;
    }
}