package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static boolean validate(List<Integer> pages){
        if(pages.contains(1) || pages.contains(2)) {
            return false;
        }else if (pages.contains(399) || pages.contains(400)) {
            return false;
        }else if (pages.get(0) < 1 || pages.get(1) > 400 ) {
            return false;
        }else if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }else if (pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0){
            return false;
        }else{
            return true;
        }
    }
}