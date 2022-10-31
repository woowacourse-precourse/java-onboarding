package onboarding.feature7;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ResultView {
    private List<Entry<String, Integer>> results;

    public ResultView(Map<String, Integer> recommendationScores) {
        filterZeroScore(recommendationScores);
        results = new ArrayList<>(recommendationScores.entrySet());
    }

    public void filterZeroScore(Map<String, Integer> recommendationScores) {
        Set<String> keysToBeDeleted = new HashSet<>();
        for (Map.Entry<String, Integer> person : recommendationScores.entrySet()) {
            if (person.getValue() == 0) {
                keysToBeDeleted.add(person.getKey());
            }
        }
        keysToBeDeleted.stream().forEach(key -> recommendationScores.remove(key));
    }

    public List<String> getResultIdsFromScores() {
        List<String> resultIds = new ArrayList<>();
        Collections.sort(results, myComparator);
        for (Entry<String, Integer> result : results) {
            resultIds.add(result.getKey());
        }
        cutToSize(5, resultIds);
        return resultIds;
    }

    Comparator<Entry<String, Integer>> myComparator = new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> currentPerson, Entry<String, Integer> nextPerson) {
            Integer scoreOfCurrentPerson = currentPerson.getValue();
            Integer scoreOfNextPerson = nextPerson.getValue();
            String idOfCurrentPerson = currentPerson.getKey();
            String idOfNextPerson = nextPerson.getKey();

            if (scoreOfNextPerson.compareTo(scoreOfCurrentPerson) == 0) {
                return idOfCurrentPerson.compareTo(idOfNextPerson);
            }
            return scoreOfNextPerson.compareTo(scoreOfCurrentPerson);
        }
    };

    public void cutToSize(int sizeNumber, List<String> resultIds) {
        while (resultIds.size() > 5) {
            int lastIndex = resultIds.size() - 1;
            resultIds.remove(lastIndex);
        }
    }
}
