package problem1;

import java.util.List;

public class JudgeException {

    public boolean judgeException(List<Integer> user) {

        Integer firstPage = 1;
        Integer LastPage = 400;

        //첫장 혹은 마지막 장
        if(user.contains(firstPage) || user.contains(LastPage)) {
            return true;
        }else if(user.get(0)%2==0 || user.get(1)%2!=0) {
            //왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 경우
            return true;
        }else if(user.get(1) != user.get(0)+1) {
            //바로 옆 페이지가 아닌 경우
            return true;
        }

        return false;
    }
}
