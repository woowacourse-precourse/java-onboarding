package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pageException(pobi, crong) == -1) {
            return -1;
        }
        User Pobi = new User(pobi);
        User Crong = new User(crong);
        answer = numCompare(Pobi.maxVal, Crong.maxVal);
        return answer;
    }

    public static int pageException(List<Integer> usr1, List<Integer> usr2) {
        if (pageInRange(usr1, usr2) == -1) {
            return -1;
        }
        if (evenOddCheck(usr1, usr2) == -1) {
            return -1;
        }
        if (pagesInPair(usr1, usr2) == -1) {
            return -1;
        }
        return 1;
    }

    public static int numCompare(int usr1Max, int usr2Max) {
        if (usr1Max == usr2Max) {
            return 0;
        }
        if (usr1Max > usr2Max) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int pageInRange(List<Integer> usr1, List<Integer> usr2) {

        for (int i = 0; i < 2; i++) {
            if (usr1.get(i) <= 0 || usr1.get(i) > 400) {
                return -1;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (usr2.get(i) <= 0 || usr2.get(i) > 400) {
                return -1;
            }
        }
        return 1;
    }

    public static int evenOddCheck(List<Integer> usr1, List<Integer> usr2) {
        if (usr1.get(0) % 2 != 1 || usr1.get(1) % 2 != 0) {
            return -1;
        }
        if (usr2.get(0) % 2 != 1 || usr2.get(1) % 2 != 0) {
            return -1;
        }
        return 1;
    }

    public static int pagesInPair(List<Integer> usr1, List<Integer> usr2) {
        if (usr1.get(1) != usr1.get(0) + 1 || usr2.get(1) != usr2.get(0) + 1) {
            return -1;
        }
        return 1;
    }

}

class User {

    int lBookPage;
    int rBookPage;
    int maxVal;

    public User(List<Integer> user) {
        this.lBookPage = user.get(0);
        this.rBookPage = user.get(1);
        this.maxVal = getAnswer(lBookPage, rBookPage);
    }

    int getAnswer(int lPage, int rPage) {
        int answer = compare2(getMax(lPage), getMax(rPage));
        return answer;
    }

    int getSum(int page) {
        List<Integer> pageDigits = getDigit(page);
        int sum = 0;
        for (int i = 0; i < pageDigits.size(); i++) {
            sum += pageDigits.get(i);
        }
        return sum;
    }

    int getMulti(int page) {
        List<Integer> pageDigits = getDigit(page);
        int multi = 1;
        for (int i = 0; i < pageDigits.size(); i++) {
            multi *= pageDigits.get(i);
        }
        return multi;
    }

    List<Integer> getDigit(int page) {
        List<Integer> digitList = new ArrayList<Integer>();
        while (page != 0) {
            digitList.add(page % 10);
            page /= 10;
        }
        return digitList;
    }

    int getMax(int bookPage) {
        int midMax = compare2(getSum(bookPage), getMulti(bookPage));
        return midMax;
    }

    int compare2(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}