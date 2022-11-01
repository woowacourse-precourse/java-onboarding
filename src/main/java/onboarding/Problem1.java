package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {

    // 각 자릿 수 더하기
    public static int plusPage(ArrayList<Integer> pagelist) {
        int sum = 0;
        for (int element : pagelist) {
            sum += element;
        }
        return sum;
    }

    // 각 자릿 수 곱하기
    public static int multiplyPage(ArrayList<Integer> pageList) {
        int sum = 1;
        for (int element : pageList) {
            sum *= element;
        }
        return sum;
    }

    // 페이지 각 자릿 수 떼어내기
    public static ArrayList<Integer> convertPage(int page) {
        String convertedPage = Integer.toString(page);
        ArrayList<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < convertedPage.length(); i++) {
            pageList.add(Integer.parseInt(String.valueOf(convertedPage.charAt(i))));
        }
        return pageList;

    }

    // 곱한 수와 더한 수 비교해서 더 높은 수 찾기
    public static int comparePlusAndMulti(int plusedPage, int multipliedPage) {
        if (plusedPage < multipliedPage) {
            return multipliedPage;
        }else if (plusedPage > multipliedPage) {
            return plusedPage;
        }else {
            return plusedPage;
        }
    }

    // 첫 번째 페이지와 두 번째 페이지 중 더 높은 페이지 찾기
    public static int compareFirstAndSecond(int firstPage, int secondPage) {
        if (firstPage < secondPage) {
            return secondPage;
        }else if (firstPage > secondPage) {
            return firstPage;
        }else {
            return firstPage;
        }
    }

    // 포비와 크롱의 최종 페이지 수 비교하여 높은 수 찾기
    public static int comparePobiAndCrong(int pobi, int crong) {
        if (pobi < crong) {
            return 2;
        }else if (pobi > crong) {
            return 1;
        }else {
            return 0;
        }
    }

    // 예외 처리
    public static boolean exceptionAll (List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) {
            return true;
        }else if (pobi.get(0) >= 400 || pobi.get(1) > 400) {
            return true;
        }else if (crong.get(0) >= 400 || crong.get(1) > 400 ) {
            return true;
        }else if (pobi.get(0) != (pobi.get(1) -1)) {
            return true;
        }else if (crong.get(0) != (crong.get(1) -1)) {
            return true;
        }else if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            return true;
        }else return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(exceptionAll(pobi, crong)) {
            return -1;
        }

        ArrayList<ArrayList<Integer>> pobiPageListList = new ArrayList<>();
        pobiPageListList.add(convertPage(pobi.get(0)));
        pobiPageListList.add(convertPage(pobi.get(1)));

        ArrayList<ArrayList<Integer>> crongPageListList = new ArrayList<>();
        crongPageListList.add(convertPage(crong.get(0)));
        crongPageListList.add(convertPage(crong.get(1)));


        List<Integer> pobiPage = new ArrayList<>();
        List<Integer> crongPage = new ArrayList<>();


        int realPobiPage;
        int realCrongPage;

        pobiPage.add(comparePlusAndMulti(plusPage(pobiPageListList.get(0)), multiplyPage(pobiPageListList.get(0))));
        pobiPage.add(comparePlusAndMulti(plusPage(pobiPageListList.get(1)), multiplyPage(pobiPageListList.get(1)));
        realPobiPage = compareFirstAndSecond(pobiPage.get(0), pobiPage.get(1));

        crongPage.add(comparePlusAndMulti(plusPage(crongPageListList.get(0)), multiplyPage(crongPageListList.get(0))));
        crongPage.add(comparePlusAndMulti(plusPage(crongPageListList.get(1)), multiplyPage(crongPageListList.get(1))));
        realCrongPage = compareFirstAndSecond(crongPage.get(0), crongPage.get(1));

        return comparePobiAndCrong(realPobiPage, realCrongPage);

    }
}

