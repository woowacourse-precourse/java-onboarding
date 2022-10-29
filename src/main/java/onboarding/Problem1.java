package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!PageSizeCheck(pobi) || !PageSizeCheck(crong)) {
            return -1;
        }
        if(!ListSizeCheck(pobi) || !ListSizeCheck(crong)) {
            return -1;
        }
        if(!PageConnectCheck(pobi) || !PageConnectCheck(crong)) {
            return -1;
        }
        if(!LeftRightCheck(pobi) || !LeftRightCheck(crong)) {
            return -1;
        }
        return pobicrongcompare(pobi, crong);
    }

    public static int pobicrongcompare(List<Integer> pobi, List<Integer> crong){        //비교
        int pobiScore = Math.max(pluscompare(pobi), multicompare(pobi));
        int crongscore = Math.max(pluscompare(crong), multicompare(crong));
        if (pobiScore > crongscore){
            return 1;
        } else if (pobiScore < crongscore) {
            return 2;
        } else{
            return 0;
        }

    }
    public static boolean PageSizeCheck(List<Integer> list){                         // 첫페이지 마지막 페이지인지 확인
        if(list.get(0) > 1 & list.get(1) < 400 ){
            return true;
        }
        return false;

    }
    public static boolean ListSizeCheck(List<Integer> list){                                 // 리스트 크기가 2인지 확인
        if(list.size() ==2){
            return true;
        }
        return false;
    }

    public static boolean PageConnectCheck(List<Integer> list){                              // 입력된 페이지의 차이가 1인지 확인
        if((list.get(1) - list.get(0)) == 1){
            return true;
        }
        return false;
    }
    public static boolean LeftRightCheck(List<Integer> list){                             // 왼쪽은 홀수페이지인지 오른쪽은 짝수 페이지인지 확인
        if(list.get(0) % 2 ==1 & list.get(1) % 2 ==0){
            return true;
        }
        return false;
    }

    public static int PlusCalculate(int pagenumber){
        int sum =0;
        while(pagenumber != 0){
            sum += pagenumber % 10;
            pagenumber /= 10;

        }
        return sum;
    }

    public static int MultiCalculate(int pagenumber){
        int sum = 1;
        while(pagenumber!=0){
            sum *= pagenumber % 10;
            pagenumber /= 10;
        }
        return sum;
    }

    public static int pluscompare(List<Integer> pc){
        int themax = Math.max(PlusCalculate(pc.get(0)), PlusCalculate(pc.get(1)));
        return themax;
}
    public static int multicompare(List<Integer> mc){
        int themax = Math.max(MultiCalculate(mc.get(0)), MultiCalculate(mc.get(1)));
        return themax;
    }
}
