package onboarding;

import java.util.ArrayList;

class Clap {
    ArrayList<Integer> numberList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();

    Clap(int number) throws RestrictException {
        if (number > 10000 || number < 1) {
            throw new RestrictException("OutOfRange");
        }
        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }
        for (Integer value : numberList) {
            int radix = 1;
            for (int i = 1; radix <= value; i++) {
                stringList.add(value.toString().split("")[i - 1]);
                radix *= 10;
            }
        }
    }

    public int findClapNumber() {
        int clapNumber = 0;
        for (String element : this.stringList) {
            if (element.equals("3") || element.equals("6") || element.equals("9")) {
                clapNumber += 1;
            }
        }
        return clapNumber;
    }
}

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        try {
            Clap numberCandidate = new Clap(number);
            answer = numberCandidate.findClapNumber();
        } catch (RestrictException e) {
            System.out.println(e.exMsg);
            return -1;
        }
        return answer;
    }
}
