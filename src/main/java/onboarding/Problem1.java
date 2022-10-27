package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int addPageNum(Integer pageNum){
        int result = 0;
        String pageStr = pageNum.toString();
        for(String numToken : pageStr.split("")){
            result += Integer.parseInt(numToken);
        }

        return result;
    }

    static int mulPageNum(Integer pageNum){
        int result = 1;
        String pageStr = pageNum.toString();
        for(String numToken : pageStr.split("")){
            result *= Integer.parseInt(numToken);
        }

        return result;
    }

}