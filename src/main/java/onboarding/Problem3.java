package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
    /*
    Game369 클래스는 다음과 같은 기능을 함.
    생성자에서 number를 받아 calc 메서드를 통해 3, 6, 9 가 들어간 횟수를 계산함.
    calc 메서드에서는 number를 String으로 치환하여 Pattern과 Matcher클래스를 이용하여 3, 6, 9의 개수를 카운트
     */
    public static int solution(int number) {
        int answer = 0;
        Game369 game = new Game369(number);
        answer = game.getCount();
        return answer;
    }
}

class Game369 {
    private int number;
    private int count;

    Game369(int number) {
        this.number =  number;
        count = 0;
        calc();
    }

    void calc() {
        String numStr;
        Pattern pattern;
        Matcher match;
        for(int i = 1; i < number+1; i++) {
            numStr = Integer.toString(i);
            pattern = Pattern.compile("[369]");
            match = pattern.matcher(numStr);
            while(match.find()) {
                count = count + 1;
            }

        }
    }

    int getCount() {
        return count;
    }
}
