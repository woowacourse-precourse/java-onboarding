package onboarding.prob3.domain;

public class ClapCounter {

    public int solve(int number) {
        return getResult(number);
    }
    final int calculate(int number) {
        int total = 0;
        String value = String.valueOf(number);
        for (int i = 0; i < value.length(); i++) {
            String var = String.valueOf(value.charAt(i));
            if ("3".equals(var)) total++;
            else if ("6".equals(var)) total++;
            else if ("9".equals(var)) total++;
        }
        return total;
    }

    final int getResult(int dest) {
        int total = 0;
        for (int i = 1; i <= dest; i++) {
            total += calculate(i);
        }
        return total;
    }

}
