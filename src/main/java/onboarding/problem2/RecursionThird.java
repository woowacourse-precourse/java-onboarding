package onboarding.problem2;

import java.util.LinkedList;

public class RecursionThird {

    public static LinkedList<String> recursiveThird(LinkedList<String> repository) {

        int k = 0;
        while (k < repository.size()-1) {

            String collect = repository.get(k);
            String next = repository.get(k + 1);
// browoanoommnaon
            if (collect.equals(next)) {
                repository.remove(k);
                repository.remove(k);
            }
            k++;
        }

        return repository;
}
