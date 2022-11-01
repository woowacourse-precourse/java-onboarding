package onboarding;

import java.util.List;

class Problem1 {
    private static int FIRST_PAGE = 1;
    private static int LAST_PAGE =400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
            try {
                if (!(validPage(pobi) && validPage(crong))){
                    return -1;
                }
                return compare(biggerPage(pobi), biggerPage(crong));
            }catch (Exception e) {
                return -1;
            }

    }


    public static boolean validPage(List<Integer> integerList){
        // 리스트 체크
        if(integerList ==null)  return false;
        if(integerList.size() != 2) return false; //리스트 페이지 여러개 주어지는 예외

        //페이지 요소값 체크
        for (Integer num : integerList){
            if (num ==null) return false;                 //요소값 중 하나라도 null값이면, false

//            if (num ==  FIRST_PAGE || num == LAST_PAGE)  return false; //요소값 중 하나라도 첫페이지나 마지막페이지면, false
            if ( FIRST_PAGE >= num || num >= LAST_PAGE) return false; //요소값 중 하나라도 페이지 수를 넘어가면, false
        }

        // 페이지 연결 체크
        int lpage = integerList.get(0);
        int rpage = integerList.get(1);
        if (!(lpage%2!=0 && rpage%2==0)) return false;
        if (lpage+1 != rpage) return false;

        return true;
    }

    public static int calculate(int num){
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
        int lPage = calculate(integerList.get(0));
        int rPage = calculate(integerList.get(1));

        return Math.max(lPage,rPage);
    }

    public static int compare(int pobi, int crong){
        if (pobi>crong) return 1;
        else if (pobi<crong) return 2;
        return 0;

    }



}