package onboarding;

import java.util.List;

class Problem1 {
    private static boolean check(List<Integer> list){
        int first = list.get(0);
        int second = list.get(1);
        if(first % 2 == 0){
            return false;
        }
        return second != first + 1;
    }
    private static int getSumOfEachNumber(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    private  static int getMultipleOfEachNumber(int num){
        int mul = 1;
        while(num != 0){
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if(check(pobi) || check(crong)){
            return -1;
        }

        int pobiMax = 0, psum, pmul;
        for(int p:pobi){
            psum = getSumOfEachNumber(p);
            pobiMax = Math.max(pobiMax, psum);
            pmul = getMultipleOfEachNumber(p);
            pobiMax = Math.max(pobiMax, pmul);
        }

        int crongMax = 0, csum, cmul;
        for(int c:crong){
            csum = getSumOfEachNumber(c);
            crongMax = Math.max(crongMax, csum);
            cmul = getMultipleOfEachNumber(c);
            crongMax = Math.max(crongMax, cmul);
        }

        System.out.println("포비: "+pobiMax+" 크롱: "+crongMax);

        if(pobiMax == crongMax){
            answer = 0;
        } else if(pobiMax > crongMax){
            answer = 1;
        } else{
            answer = 2;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println("안녕하세요");
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        System.out.println(solution(pobi, crong)); // -1

        pobi = List.of(131, 132);
        crong = List.of(211, 212);
        System.out.println(solution(pobi, crong)); // 1

        pobi = List.of(97, 98);
        crong = List.of(197, 198);
        System.out.println(solution(pobi, crong)); // 0

        pobi = List.of(11, 12);
        crong = List.of(9, 10);
        System.out.println(solution(pobi, crong)); // 2

    }
}