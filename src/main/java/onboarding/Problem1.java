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

    public static int comparePlusAndMulti(int plusedpage, int multipliedpage) {
        if (plusedpage < multipliedpage) {
            return multipliedpage;
        }else if (plusedpage > multipliedpage) {
            return plusedpage;
        }else {
            return plusedpage;
        }
    }

    public static ArrayList<Integer> convertPage(int page) {
        String convertedpage = Integer.toString(page);
        ArrayList<Integer> pagelist = new ArrayList<>();
        for (int i = 0; i < convertedpage.length(); i++) {
            pagelist.add(Integer.parseInt(String.valueOf(convertedpage.charAt(i))));
        }
        return pagelist;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        ArrayList<ArrayList<Integer>> pobipagelistlist = new ArrayList<>();
        pobipagelistlist.add(convertPage(pobi.get(0)));
        pobipagelistlist.add(convertPage(pobi.get(1)));

        ArrayList<ArrayList<Integer>> crongpagelistlist = new ArrayList<>();
        crongpagelistlist.add(convertPage(crong.get(0)));
        crongpagelistlist.add(convertPage(crong.get(1)));

        return answer;

    }
}

