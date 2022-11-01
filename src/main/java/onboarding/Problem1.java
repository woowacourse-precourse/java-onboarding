package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<String> pobi, List<String> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int exception(List<String> pobi, List<String> crong) {
        int exceptinoValue = 0;

        if ((pobi.get(0) == "0" || pobi.get(pobi.size() - 1) == "400") || (crong.get(0) == "0" || crong.get(crong.size() - 1) == "400"))
            exceptinoValue = -1;
        else if (((Integer.parseInt(pobi.get(0)) % 2) == 0) || ((Integer.parseInt(crong.get(0)) % 2) == 0))
            exceptinoValue = -1;
        else if (((Integer.parseInt(pobi.get(0)) + 1) != (Integer.parseInt(pobi.get(1)))) || ((Integer.parseInt(crong.get(0)) + 1) != (Integer.parseInt(crong.get(1)))))
            exceptinoValue = -1;
        else exceptinoValue = 0;

        return exceptinoValue;
    }
}