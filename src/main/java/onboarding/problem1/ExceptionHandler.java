package onboarding.problem1;

import java.util.List;

// refactor : else 제거
public class ExceptionHandler {

    // 예외 처리 실행하기
    public static boolean runtimeException(List<Integer> pageByPlayer) {
        //given
        int leftNumber = pageByPlayer.get(0);
        int rightNumber = pageByPlayer.get(1);

        //when
        if (leftNumber < 1){return true;}
        if (rightNumber >= 400){return true;}
        if (rightNumber - leftNumber > 1) {return true;}

        return false;
    }
}
