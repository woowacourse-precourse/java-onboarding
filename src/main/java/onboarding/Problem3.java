package onboarding;

import problem3.Claps;

public class Problem3 {
    public static int solution(int number) {
        Claps claps = new Claps(new int[number + 1]);
        return claps.clap();
    }
}