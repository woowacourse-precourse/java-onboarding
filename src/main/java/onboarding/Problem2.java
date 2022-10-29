package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean changed = true;

        String[] cryptoArr = cryptogram.split("");
        List<String> cryptoList = Arrays.asList(cryptoArr);

        //새로운 List에 중복 문자 제외하고 넣는다. 바뀌지 않을 때까지 반복
        while (changed) {
            List<String> cryptoListCopy = new ArrayList<>();
            for (int i = 0; i < cryptoList.size() - 1; i++) {
                String str1 = cryptoList.get(i);
                String str2 = cryptoList.get(i + 1);
                if (str1.equals(str2))
                    i += 1;
                else
                    cryptoListCopy.add(cryptoList.get(i));
            }

            //마지막 문자는 for에서 넣지 않으므로 넣어준다. 바로 이전 문자와 중복되지 않는 경우에만!
            if (!cryptoList.get(cryptoList.size() - 2).equals(cryptoList.get(cryptoList.size() - 1)))
                cryptoListCopy.add(cryptoList.get(cryptoList.size() - 1));

            if (cryptoList.equals(cryptoListCopy))
                changed = false;
            else
                changed = true;
            cryptoList = cryptoListCopy;

            //결과 list가 비어있다면 루프 종료
            if (cryptoList.isEmpty())
                break;
        }
        String answer= String.join("", cryptoList);
        return answer;
    }
}
