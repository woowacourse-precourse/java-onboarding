package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        //if left page is bigger than or same as left
        if((pobi.get(0) >= pobi.get(1)) || ((crong.get(0) >= crong.get(1)))){
            answer = -1;
        }

        //if the page is in first or last page
        if((pobi.get(0).equals(1) || pobi.get(1).equals(2)) || (crong.get(0).equals((1)) || crong.get(1).equals(2))){
            answer = -1;
        } else if((pobi.get(0).equals(399) || pobi.get(1).equals(400)) || ((crong.get(0).equals(399)) || crong.get(1).equals(400))){
            answer = -1;
        }

        //if the difference of page is not 1
        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)){
            answer = -1;
        }

        //if left page is even, right page is odd
        if((((pobi.get(0) % 2) == 0) || ((pobi.get(1) % 2) != 0))){
            answer = -1;
        } else if((((crong.get(0) % 2) == 0) || ((crong.get(1) % 2) != 0))) {
            answer = -1;
        }
        return answer;
    }
}