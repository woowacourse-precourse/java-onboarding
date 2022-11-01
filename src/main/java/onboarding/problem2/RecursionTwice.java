package onboarding.problem2;

import java.util.LinkedList;

public class RecursionTwice {

    public static LinkedList<String> recursiveTwice(LinkedList<String> repository) {

        int j = 0;
        while (j < repository.size()-1) {

            String collect = repository.get(j);
            String next = repository.get(j + 1);
// browoanoommnaon
            if (collect.equals(next)) {
                repository.remove(j);
                repository.remove(j);
            }
            j++;
        }

        return repository;
    }
}
