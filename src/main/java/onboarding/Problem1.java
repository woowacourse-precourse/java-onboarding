package onboarding;

import java.util.List;

class Problem1 {
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobiScore;
        int crongScore;

        if(validation(pobi, crong)){
            pobiScore = getMaxValue(pobi);
            crongScore = getMaxValue(crong);
            answer = compareScore(pobiScore, crongScore);
        }
        return answer;
    }
    public static boolean validation(List<Integer> array1, List<Integer> array2){
        //페이지 차이가 1인지 아닌지 확인하기 위한 변수
        int pobi = Math.abs(array1.get(0) - array1.get(1));
        int crong = Math.abs(array2.get(0) - array2.get(1));
        if(array1.get(0) == MIN_PAGE || array1.get(1) == MAX_PAGE || array2.get(0) == MIN_PAGE || array2.get(1) == MAX_PAGE){ // 시작면이나 마지막면일 때, 두 페이지의 차가 2이상일 때 return false
            return false;
        }
        return pobi <= 1 && crong <= 1;
    }

    public static int add(int number){
        int result = 0;
        String[] array = String.valueOf(number).split("");
        for(String s: array){
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static int multiple(int number){
        int result = 1;
        String[] array = String.valueOf(number).split("");
        for(String s: array){
            result *= Integer.parseInt(s);
        }
        return result;
    }

    public static int getMaxValue(List<Integer> array){
        int addResult = Math.max(add(array.get(0)), add(array.get(1)));
        int multipleResult = Math.max(multiple(array.get(0)), multiple(array.get(1)));
        return Math.max(addResult, multipleResult);
    }

    public static int compareScore(int pobiScore, int crongScore){
        if(pobiScore > crongScore) return 1;
        if(pobiScore == crongScore) return 0;
        return 2;
    }
}