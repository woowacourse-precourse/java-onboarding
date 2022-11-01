package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    /**
     * 2글자 이상 중복되는 이름을 가진 사람들의 이메일을 리턴합니다.
     */
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> dupExistsEmails = new ArrayList<>();

        List<String> emails = getColumn(forms, 0);
        List<String> names = getColumn(forms, 1);

        List<Boolean> dupExists = mapDuplicateExists(names);

        for (int i = 0; i < forms.size(); i++) {
            if (dupExists.get(i)) {
                dupExistsEmails.add(emails.get(i));
            }
        }

        return sortedUniqueList(dupExistsEmails);
    }

    /**
    * 2차원 리스트에서, 각 리스트의 i번째 원소들로 이루어진 리스트를 리턴합니다.
    */
    private static List<String> getColumn(List<List<String>> matrix, Integer i) {
        ArrayList<String> column = new ArrayList<>();

        for (List<String> row: matrix) {
            column.add(row.get(i));
        }

        return column;
    }

    /**
     * 리스트의 중복을 제거하고 오름차순으로 정렬한 결과를 리턴합니다.
     */
    private static List<String> sortedUniqueList(List<String> list) {
        Collection<String> set = new TreeSet<>(list);
        return new ArrayList<>(set);
    }

    /**
     * 문자열의 모든 길이 2인 부분문자열의 집합을 리턴합니다.
     * <p>
     * "가나다라가나다" -> {"가나", "나다", "다라", "라가"}
     */
    private static Set<String> lengthTwoSubstringSet(String s) {
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < s.length() - 1; i++) {
            result.add(s.substring(i, i + 2));
        }

        return result;
    }

    /**
     * 리스트의 각 문자열에 대해, 리스트에 자신과 2글자 이상 중복되는 문자열이 존재하면
     * {@code true}, 존재하지 않으면 {@code false}를 가지는 리스트를 리턴합니다.
     */
    private static List<Boolean> mapDuplicateExists(Collection<String> list) {
        ArrayList<Boolean> dupExistsList = new ArrayList<>();
        Counter<String> counter = new Counter<>();

        for (String s: list) {
            Set<String> substrSet = lengthTwoSubstringSet(s);
            counter.addAll(substrSet);
        }

        for (String s: list) {
            Set<String> substrSet = lengthTwoSubstringSet(s);
            Boolean dupExists = isAnyElementDuplicate(substrSet, counter);
            dupExistsList.add(dupExists);
        }

        return dupExistsList;
    }

    /**
     * 리스트의 원소 중 하나라도 카운터에 중복이 있다면 {@code true}, 그렇지 않다면
     * {@code false}를 리턴합니다.
     */
    private static Boolean isAnyElementDuplicate(Collection<String> list, Counter<String> counter) {
        for (String s: list) {
            if (counter.count(s) >= 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 원소들을 추가하고, 특정 원소의 개수를 알 수 있는 카운터
     */
    private static class Counter<T> {
        private HashMap<T, Integer> map = new HashMap<>();

        /**
         * 카운터에 원소를 추가합니다.
         */
        public void add(T t) {
            map.merge(t, 1, Integer::sum);
        }

        /**
         * 컬렉션의 각 원소를 카운터에 추가합니다.
         */
        public void addAll(Collection<T> c) {
            for (T t: c) {
                add(t);
            }
        }

        /**
         * 카운터에 특정 원소가 몇 개 있는지 리턴합니다.
         * 해당 원소가 없으면 0을 리턴합니다.
         */
        public Integer count(T t) {
            return map.getOrDefault(t, 0);
        }
    }
}
