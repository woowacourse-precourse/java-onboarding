package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        System.out.println(pobi.get(0).getClass().getName());
        int pobiMax = getMaxPage(pobi.get(0)) > getMaxPage(pobi.get(0)) ? getMaxPage(pobi.get(0)) : getMaxPage(pobi.get(0));
        int crongMax = getMaxPage(crong.get(0)) > getMaxPage(crong.get(0)) ? getMaxPage(crong.get(0)) : getMaxPage(crong.get(0));

        return answer;
    }

    public static int getMaxPage(int page) {
        int plus = 0;
        int multi = 1;
        String pageNums = Integer.toString(page);

        for(char pageNum : pageNums.toCharArray()) {
            int num = Character.getNumericValue(pageNum);
            plus += num;
            multi *= num;
        }
        return (plus > multi) ? plus : multi;
    }
}