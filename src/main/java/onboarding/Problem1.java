package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
//    public static List<Integer> pobi = new ArrayList<>();
//
//    public static List<Integer> crong = new ArrayList<>();

    public static int listMax(List<Integer> list){
        int listMax=0;
        if(list.get(0) != list.get(1)-1 | list.get(0)%2 != 1 | list.get(1)%2 != 0 | list.get(0) <= 1 | list.get(1) >= 400){
            return listMax;}
        for(int i=0; i<list.size(); i++) {
            int num = list.get(i);
//            if (num <= 1 | num >= 400 ) {
//                listMax = 0;
//                System.out.println("listMax: " + listMax);
//                return listMax;
//            } else {
                int plus;
                int by;
                if (num >= 100) {
                    plus = num / 100 + num % 100 / 10 + num % 10;
//                    System.out.println("plus: " + plus);
                    by = (num / 100) * (num % 100 / 10) * (num % 10);
//                    System.out.println("by: " + by);
                } else {
                    plus = num % 100 / 10 + num % 10;
//                    System.out.println("plus: " + plus);
                    by = (num % 100 / 10) * (num % 10);
//                    System.out.println("by: " + by);
                }
                int max = Math.max(plus, by);
//                System.out.println("max: " + max);
                listMax = (listMax > max) ? listMax : max;
//                System.out.println("listMax: " + listMax);
//            }
        }
//        System.out.println("finalListMax: " + listMax);
        return listMax;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int maxPobi = listMax(pobi);
        if (maxPobi==0) {return answer;}
        int maxCrong = listMax(crong);
        if (maxCrong==0) {return answer;}

        if (maxPobi > maxCrong) {answer = 1;}
        else if (maxPobi < maxCrong) {answer = 2;}
        else if (maxPobi == maxCrong) {answer = 0;}
        return answer;
    }

//    public static void main(String[] args){
//        pobi.add(99);
//        pobi.add(102);
//        crong.add(211);
//        crong.add(212);
//        System.out.println(solution(pobi, crong));
//    }
}