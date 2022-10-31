package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
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
