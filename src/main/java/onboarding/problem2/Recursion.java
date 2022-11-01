package onboarding.problem2;

import java.util.LinkedList;

import static java.lang.String.valueOf;

// 재귀 기능
public class Recursion {

    public static LinkedList<String> recursive(LinkedList<String> repository) {


        int i = 0;
        while (i < repository.size()-1) {

            String collect = repository.get(i);
            String next = repository.get(i + 1);
            if (collect.equals(next)) {
                repository.remove(i);
                repository.remove(i);
            }
            i++;
        }
        return repository;


        // Comment : StackOverflowError 피하는 재귀 메서드로 통합해보기
        // recursive(repository);
    }
}
