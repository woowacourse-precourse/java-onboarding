package onboarding;

import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getScore(List<Integer> one){
        int[] leftrightArr = new int[2];
        for(int listIndex=0; listIndex<2; listIndex++){
            //각 숫자 더하기 빼기
            for(int i=0;i<3;i++){
                int first = one.get(listIndex)/100;
                int second = (one.get(listIndex)/10) %10;
                int third = one.get(listIndex)%10;
                int add = first+second+third;
                int mul= first*second*third;

                leftrightArr[listIndex] = Math.max(add, mul);
            }
        }
        return Math.max(leftrightArr[0], leftrightArr[1]);
    }

    public static int exception(List<Integer> pobi, List<Integer> crong) {
        //페이지 연속
        int pageDiffpobi = Math.abs(pobi.get(0) - pobi.get(1));
        int pageDiffcrong = Math.abs(crong.get(0) - crong.get(1));
        if(pageDiffcrong != 1 || pageDiffpobi != 1){
            return -1;
        }

        //1 이나 400 나오면
        if((pobi.get(0)==1) || (crong.get(0)==1)) {return -1;}
        if((pobi.get(1)==400) || (crong.get(1)==400)) {return -1;}


        return 0;
    }
}