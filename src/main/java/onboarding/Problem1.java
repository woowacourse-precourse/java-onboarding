package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int plusPage(ArrayList<Integer> pagelist) {
        int sum = 0;
        for (int element : pagelist) {
            sum += element;
        }
        return sum;
    }

    public static int multiplyPage(ArrayList<Integer> pagelist) {
        int sum = 1;
        for (int element : pagelist) {
            sum *= element;
        }
        return sum;
    }

    public static ArrayList<Integer> convertPage(int page) {
        String convertedpage = Integer.toString(page);
        ArrayList<Integer> pagelist = new ArrayList<>();
        for (int i = 0; i < convertedpage.length(); i++) {
            pagelist.add(Integer.parseInt(String.valueOf(convertedpage.charAt(i))));
        }
        return pagelist;

    }

    public static int comparePlusAndMulti(int plusedpage, int multipliedpage) {
        if (plusedpage < multipliedpage) {
            return multipliedpage;
        }else if (plusedpage > multipliedpage) {
            return plusedpage;
        }else {
            return plusedpage;
        }
    }

    public static int compareFirstAndSecond(int firstpage, int secondpage) {
        if (firstpage < secondpage) {
            return secondpage;
        }else if (firstpage > secondpage) {
            return firstpage;
        }else {
            return firstpage;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        ArrayList<ArrayList<Integer>> pobipagelistlist = new ArrayList<>();
        pobipagelistlist.add(convertPage(pobi.get(0)));
        pobipagelistlist.add(convertPage(pobi.get(1)));

        ArrayList<ArrayList<Integer>> crongpagelistlist = new ArrayList<>();
        crongpagelistlist.add(convertPage(crong.get(0)));
        crongpagelistlist.add(convertPage(crong.get(1)));

        int pobifirstpage;
        int pobifirstpageplus;
        int pobifirstpagemultiply;

        int pobisecondpage;
        int pobisecondpageplus;
        int pobisecondpagemultiply;

        int realpobipage;

        pobifirstpageplus = plusPage(pobipagelistlist.get(0));
        pobifirstpagemultiply = multiplyPage(pobipagelistlist.get(0));
        pobifirstpage = comparePlusAndMulti(pobifirstpageplus, pobifirstpagemultiply);

        pobisecondpageplus = plusPage(pobipagelistlist.get(1));
        pobisecondpagemultiply = multiplyPage(pobipagelistlist.get(1));
        pobisecondpage = comparePlusAndMulti(pobisecondpageplus, pobisecondpagemultiply);

        realpobipage = compareFirstAndSecond(pobifirstpage, pobisecondpage);

        int crongfirstpage;
        int crongfirstpageplus;
        int crongfirstpagemultiply;

        int crongsecondpage;
        int crongsecondpageplus;
        int crongsecondpagemultiply;

        int realcrongpage;
        crongfirstpageplus = plusPage(crongpagelistlist.get(0));
        crongfirstpagemultiply = multiplyPage(crongpagelistlist.get(0));
        crongfirstpage = comparePlusAndMulti(crongfirstpageplus, crongfirstpagemultiply);

        crongsecondpageplus = plusPage(crongpagelistlist.get(1));
        crongsecondpagemultiply = multiplyPage(crongpagelistlist.get(1));
        crongsecondpage = comparePlusAndMulti(crongsecondpageplus, crongsecondpagemultiply);

        return answer;

    }
}

