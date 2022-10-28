package onboarding;

import java.util.*;

class Problem1 {
    static int pobiMax;
    static int crongMax;
    static int answer;
    static List<Integer> pobiNumbers = new ArrayList<>();
    static List<Integer> crongNumbers = new ArrayList<>();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        max(pobi, crong);
        answer = maxCompare(pobi, crong);
        exception(pobi, crong);
        return answer;
    }

    public static void max(List<Integer> pobi, List<Integer> crong) {
        pobiPlus(pobi);
        crongPlus(crong);
        pobiMultiplication(pobi);
        crongMultiplication(crong);

        pobiNumbers.sort(Comparator.reverseOrder());
        crongNumbers.sort(Comparator.reverseOrder());

        pobiMax = pobiNumbers.get(0);
        crongMax = crongNumbers.get(0);

        pobiNumbers.clear();
        crongNumbers.clear();
    }

    public static int maxCompare(List<Integer> pobi, List<Integer> crong) {
        if (pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }
        if (pobiMax == crongMax) {
            return 0;
        }
        return -1;
    }

    public static void pobiPlus(List<Integer> pobi) {
        for (int pobiPageNumber : pobi) {
            int sum = 0;
            for (int i = 0; i < pobiPageNumber; i++) {
                sum += pobiPageNumber % 10;
                pobiPageNumber /= 10;
                if (pobiPageNumber < 10) {
                    sum += pobiPageNumber;
                    break;
                }
            }
            pobiNumbers.add(sum);
        }
    }

    public static void pobiMultiplication(List<Integer> pobi) {
        for (int pobiPageNumber : pobi) {
            int sum = 1;
            for (int i = 0; i < pobiPageNumber; i++) {
                sum *= pobiPageNumber % 10;
                pobiPageNumber /= 10;
                if (pobiPageNumber < 10) {
                    sum *= pobiPageNumber;
                    break;
                }
            }
            pobiNumbers.add(sum);
        }
    }

    public static void crongPlus(List<Integer> crong) {
        for (int crongPageNumber : crong) {
            int sum = 0;
            for (int i = 0; i < crongPageNumber; i++) {
                sum += crongPageNumber % 10;
                crongPageNumber /= 10;
                if (crongPageNumber < 10) {
                    sum += crongPageNumber;
                    break;
                }
            }
            crongNumbers.add(sum);
        }
    }

    public static void crongMultiplication(List<Integer> crong) {
        for (int crongPageNumber : crong) {
            int sum = 1;
            for (int i = 0; i < crongPageNumber; i++) {
                sum *= crongPageNumber % 10;
                crongPageNumber /= 10;
                if (crongPageNumber < 10) {
                    sum *= crongPageNumber;
                    break;
                }
            }
            crongNumbers.add(sum);
        }
    }

    public static void exception(List<Integer> pobi, List<Integer> crong) {
        int pobiRightPage = pobi.get(1);
        int pobiLeftPage = pobi.get(0);
        if (pobiRightPage - pobiLeftPage != 1) {
            answer = -1;
        }

        int crongRightPage = crong.get(1);
        int crongLeftPage = crong.get(0);
        if (crongRightPage - crongLeftPage != 1) {
            answer = -1;
        }
    }
}