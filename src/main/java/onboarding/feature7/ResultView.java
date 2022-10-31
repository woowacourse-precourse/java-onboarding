package onboarding.feature7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ResultView {
    private List<Entry<String, Integer>> results;

    public ResultView(Map<String, Integer> recommendationScores) {
        results = new ArrayList<>(recommendationScores.entrySet());
    }

    public List<String> getResultIdsFromScores() {
        Collections.sort(results, myComparator);
        List<String> resultIds = new ArrayList<>();
        for (Entry<String, Integer> result : results) {
            resultIds.add(result.getKey());
        }
        return resultIds;
    }

    Comparator<Entry<String, Integer>> myComparator = new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> currentPerson, Entry<String, Integer> nextPerson) {
            Integer scoreOfCurrentPerson = currentPerson.getValue();
            Integer scoreOfNextPerson = nextPerson.getValue();
            String idOfCurrentPerson = currentPerson.getKey();
            String idOfNextPerson = nextPerson.getKey();

            System.out.println(scoreOfCurrentPerson + " " + idOfCurrentPerson);
            System.out.println(scoreOfNextPerson + " " + idOfNextPerson);

            if (scoreOfNextPerson.compareTo(scoreOfCurrentPerson) == 0) {
                return idOfCurrentPerson.compareTo(idOfNextPerson);
            }
            return scoreOfNextPerson.compareTo(scoreOfCurrentPerson);
        }
    };
}
