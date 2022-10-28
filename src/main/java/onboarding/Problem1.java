package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if(validation(pobi, crong)){

        }
        return answer;
    }
    public static boolean validation(List<Integer> array1, List<Integer> array2){
        //페이지 차이가 1인지 아닌지 확인하기 위한 변수
        int pobi = Math.abs(array1.get(0) - array1.get(1));
        int crong = Math.abs(array2.get(0) - array2.get(1));

        if(array1.get(0) == 1 || array1.get(0) == 399 || array2.get(0) == 1 || array2.get(1) == 399){ // 시작면이나 마지막면일 때, 두 페이지의 차가 2이상일 때 return false
            return false;
        } else return pobi <= 1 && crong <= 1;
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
        int result = 0;
        String[] array = String.valueOf(number).split("");
        for(String s: array){
            result *= Integer.parseInt(s);
        }
        return result;
    }
}