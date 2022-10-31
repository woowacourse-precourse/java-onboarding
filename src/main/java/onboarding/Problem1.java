package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int random(){
        Random rd = new Random();
        return rd.nextInt(400)+1;
    }
    // 난수 발생

    public static List makeList(){
        List<Integer> list = new ArrayList<>();
        list.add(random());
        list.add(random());
        return list;
    }
    // 리스트 만들기

    public static void main(String[] args){
        System.out.println(makeList());
    }
    // 리스트 초기화
    // 리스트 비교
}