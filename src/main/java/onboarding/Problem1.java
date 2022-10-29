package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!FirstLastCheck(pobi) | !FirstLastCheck(crong)) {
            throw new IllegalArgumentException("첫페이지 또는 마지막페이지를 펼쳤습니다. 다시 펼치세요.");
        }
        if(!TwoSizeCheck(pobi) | !TwoSizeCheck(crong)) {
            throw new IllegalArgumentException("왼쪽 페이지 오른쪽 페이지 이렇게 두개만 입력하세요.");
        }
        if(!ContinuousCheck(pobi) | !ContinuousCheck(crong)) {
            throw new IllegalArgumentException("입력한 왼쪽과 오른쪽 페이지를 확인하세요.");
        }
        if(!LeftRightCheck(pobi) | !LeftRightCheck(crong)) {                                                //검증에 실패하면 뭘 시켜야 하지?
            throw new IllegalArgumentException("왼쪽은 홀수 이고 오른쪽은 짝수여야 합니다.");
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

    public static boolean FirstLastCheck(List<Integer> list){                         // 첫페이지 마지막 페이지인지 확인
        if(list.get(0) > 1 & list.get(1) < 400 ){
            return true;
        }
        return false;

    }
    public static boolean TwoSizeCheck(List<Integer> list){                                 // 리스트 크기가 2인지 확인
        if(list.size() ==2){
            return true;
        }
        return false;
    }

    public static boolean ContinuousCheck(List<Integer> list){                              // 입력된 페이지의 차이가 1인지 확인
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

    public static int pluscalculate(int pagenumber){
        int sum =0;
        while(pagenumber != 0){
            sum += pagenumber % 10;
            pagenumber /= 10;

        }
        return sum;
    }

    public static int multicalculate(int pagenumber){
        int sum = 1;
        while(pagenumber!=0){
            sum *= pagenumber % 10;
            pagenumber /= 10;
        }
        return sum;
    }

    public static int pluscompare(List<Integer> pc){
        int themax = Math.max(pluscalculate(pc.get(0)), pluscalculate(pc.get(1)));
        return themax;
}
    public static int multicompare(List<Integer> mc){
        int themax = Math.max(multicalculate(mc.get(0)), multicalculate(mc.get(1)));
        return themax;
    }
}
