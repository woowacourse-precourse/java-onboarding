package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validCheck(pobi) && validCheck(crong))){
            return -1;
        }
        return compare(biggerPage(pobi), biggerPage(crong));
    }


    public static boolean validCheck(List<Integer> integerList){
// 리스트 체크
        if(integerList.isEmpty() || integerList ==null)  return false;

//요소 체크
        for (Integer i : integerList){      //오토언박싱
            if (i ==null) return false;                 //요소값 중 하나라도 null값이면, false

            int num = i.intValue();
            if (num == 1 || num == 400)  return false; //요소값 중 하나라도 첫페이지나 마지막페이지면, false
            if (1 > num || num >400) return false; //요소값 중 하나라도 페이지 수를 넘어가면, false
        }

// 페이지 연결 체크
        if (integerList.get(0).intValue()+1 != integerList.get(1).intValue()) return false;

        return true;
    }

    public static int cal(int num){
        int sum =0;
        int mul =1;

        while (num !=0){
            sum += num%10;
            mul *= num%10;
            num = num/10;
        }

        return Math.max(sum, mul);
    }

    public static int biggerPage(List<Integer> integerList){
        int lPage = cal(integerList.get(0));
        int rPage = cal(integerList.get(1));

        return Math.max(lPage,rPage);
    }

    public static int compare(int pobi, int crong){
        if (pobi>crong) return 1;
        else if (pobi<crong) return 2;
        return 0;

    }



}