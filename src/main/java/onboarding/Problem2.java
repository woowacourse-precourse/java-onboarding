package onboarding;

/*
 *  🚀 기능 명세
    주어진 문자열에 대해 반복해서 압축을 실행할 메서드 (deleteContinuousChar)
    주어진 문자열이 더이상 압축되지 않을때까지 압축을 수행할 메서드 (solution)
    *
 */

import java.util.Stack;
import javax.swing.CellRendererPane;
import onboarding.problem2.StringZipper;


public class Problem2 {
    public static String solution(String cryptogram){
        return StringZipper.zipString(cryptogram);
    }
}
