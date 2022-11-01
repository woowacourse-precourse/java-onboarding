package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Player pobiP = new Player(pobi);
        Player crongP = new Player(crong);
        List<Player> players =  new ArrayList<>(){{
            add(pobiP);
            add(crongP);
        }};

        for(Player player : players){
            if(player.getPages().get(1) - player.getPages().get(0) != 1){
                return -1;
            }
            List<Integer> results = new ArrayList<>();
            for (int page : player.getPages()) {
                List<Integer> digits = getDigits(page);
                int multiply = 1;
                int sum = 0;
                for (Integer digit : digits) {
                    multiply = multiply * digit;
                    sum = sum + digit;
                }
                results.add(multiply);
                results.add(sum);
            }
            player.setScore(Collections.max(results));
        }

        if(pobiP.getScore() > crongP.getScore()){
            return 1;
        } else if (pobiP.getScore() < crongP.getScore()) {
            return 2;
        } else {
            return 0;
        }
    }
    private static List<Integer> getDigits(int number){
        String string_number = Integer.toString(number);
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < string_number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(string_number.charAt(i)));
            digits.add(digit);
        }
        return digits;
    }
}