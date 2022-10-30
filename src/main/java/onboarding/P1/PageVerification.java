package onboarding.P1;

import java.util.List;

public class PageVerification {

    public static boolean PageCheck(List<Integer> User){
        if(!PageSizeCheck(User)) {
            return false;
        }
        if(!ListSizeCheck(User)) {
            return false;
        }
        if(!PageConnectCheck(User)) {
            return false;
        }
        if(!LeftRightCheck(User)) {
            return false;
        }
        return true;
    }

    private static boolean PageSizeCheck(List<Integer> list){                         // 첫페이지 마지막 페이지인지 확인
        if(list.get(0) > 1 & list.get(1) < 400 ){
            return true;
        }
        return false;
    }
    private static boolean ListSizeCheck(List<Integer> list){                                 // 리스트 크기가 2인지 확인
        if(list.size() ==2){
            return true;
        }
        return false;
    }
    private static boolean PageConnectCheck(List<Integer> list){                              // 입력된 페이지의 차이가 1인지 확인
        if((list.get(1) - list.get(0)) == 1){
            return true;
        }
        return false;
    }
    private static boolean LeftRightCheck(List<Integer> list){                             // 왼쪽은 홀수페이지인지 오른쪽은 짝수 페이지인지 확인
        if(list.get(0) % 2 ==1 & list.get(1) % 2 ==0){
            return true;
        }
        return false;
    }


}

