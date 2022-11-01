package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Util {

    private static final char ALPHABET_M_UPPERCASE = 'M';
    private static final char ALPHABET_M_LOWERCASE = 'm';
    private static final char ALPHABET_N_UPPERCASE = 'N';
    private static final char ALPHABET_n_LOWERCASE = 'n';

    public static List<Integer> convertIntegerToList(int integer) {
        Stream<Integer> stream = Stream
                .of(String
                        .valueOf(integer)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .boxed();
        return Arrays.asList(stream.toArray(Integer[]::new));
    }

    public static String convertCharacterListToString(List<Character> characterList) {
        return characterList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static List<Character> convertStringToCharacterList(String string) {
        return string
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    public static Character convertToOpposite(char character) {
        if (Character.isUpperCase(character)) {
            return convertCharacterUppercaseToOpposite(character);
        }
        return convertCharacterLowercaseToOpposite(character);
    }

    public static char convertCharacterUppercaseToOpposite(char character) {
        if (character < ALPHABET_N_UPPERCASE) {
            return (char) (ALPHABET_M_UPPERCASE + (ALPHABET_N_UPPERCASE - character));
        }
        return (char) (ALPHABET_N_UPPERCASE - (character - ALPHABET_M_UPPERCASE));
    }

    public static char convertCharacterLowercaseToOpposite(char character) {
        if (character < ALPHABET_n_LOWERCASE) {
            return (char) (ALPHABET_M_LOWERCASE + (ALPHABET_n_LOWERCASE - character));
        }
        return (char) (ALPHABET_n_LOWERCASE - (character - ALPHABET_M_LOWERCASE));
    }

    public static Map<String, Integer> convertSortedSetToMap(SortedSet<Map.Entry<String, Integer>> sortedSet) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (var entry : sortedSet)
            sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }

    public static List<String> sortListAscendingOrder(List<String> stringList) {
        stringList.sort(Comparator.naturalOrder());
        return stringList;
    }

    public static Map<String, Integer> sortMapByValueThenKey(Map<String, Integer> map) {
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>((e1, e2) -> {
            int result = e1.getValue().compareTo(e2.getValue());
            if (result == 0)
                return e1.getKey().compareTo(e2.getKey());
            return result * -1;
        });
        sortedSet.addAll(map.entrySet());
        return convertSortedSetToMap(sortedSet);
    }
}
