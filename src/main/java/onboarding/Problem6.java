package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkDouble(forms);
        return answer;
    }
    public static List<String> checkDouble(List<List<String>> forms) {
        System.out.println(forms.get(0).get(1));
        /**
         * 이미 회원은 다 받아져 있는 상태
         * 그러니 for문을 돌면서 fomrms 내에 있는 닉네임을 나눈것을 비교해보아야한다.
         * 닉네임이 한글만 가능하고 전체 길이는 1자 이상 20자 미만이므로
         * 최대값일때 20자 내에 연속적으로 포함되는 닉네임을 가진것을 모두 체크해야 한다.
         * 두글자 이상의 문자가 연속적으로 포함되는 닉네임이여아하므로, 체크하는 값은 slice와 같은것으로 잘라내서 봐야할듯?
         *
         *  {a,b,c,d,e,f,g}
         *
         *  연속되는 문자가 2개일때
         *  ab
         *  bc
         *  cd
         *  de
         *  ef
         *  fg
         *
         *  연속되는 문자가 3개일때
         *
         *  abc
         *  bcd
         *  cde
         *  def
         *  efg
         *
         *  연속되는 문자가 4개일때
         *
         *  a,b
         *  abc
         *  abcd
         *  abcde
         *  abcdef
         *  abcdefg
         *
         *  bc
         *  bcd
         *  bcde
         *  bcdef
         *  bcdefg
         *  cd
         *  cde
         *  cdef
         *  cdefg
         *
         *  de
         *  def
         *  defg
         *  ef
         *  efg
         *  fg
         *
         *
         * 중복되는 일부 닉네임을 리스트로 만들고, 그 리스트를 for문을 통해서 돌려봐야겠다.
         */
        List<String> result = List.of("answer");
        return result;
    }

}
