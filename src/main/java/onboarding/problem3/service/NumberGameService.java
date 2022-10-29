package onboarding.problem3.service;

import onboarding.problem3.domain.GameStrategy;

import java.util.stream.IntStream;

public class NumberGameService {

    private final GameStrategy gameStrategy;

    public NumberGameService(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public int result(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(0, (result, number) -> result + gameStrategy.count(number));
    }
}
