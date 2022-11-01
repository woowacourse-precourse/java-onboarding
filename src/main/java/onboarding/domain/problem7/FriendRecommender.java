package onboarding.domain.problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * Problem number : 7
 * Comment : 상위 최대 5명의 추천 친구 리스트를 제공한다.
 * @author doyoung
 */
public class FriendRecommender {
    private final MutualDictionary mutual;
    private final VisitsDictionary visits;
    private final Map<String, Integer> candidatePoints;
    
    public FriendRecommender(String user, FriendRelations relations, List<String> visitors) {
        this.mutual = new MutualDictionary(user, relations);
        this.visits = new VisitsDictionary(user, relations, visitors);
        this.candidatePoints = getCandidatePoints(mergeAllCandidates());
    }
    
    public List<String> getTopRecommends() {
        List<String> recommends = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortedCandidates = sortCandidatesByPoint(candidatePoints);
        int index = 0;
        while (isInRange(index, sortedCandidates.size())) {
            Map.Entry<String, Integer> candidateEntry = sortedCandidates.get(index);
            recommends.add(candidateEntry.getKey());
            index++;
        }
        return recommends;
    }
    
    private boolean isInRange(int index, int candidatesCount) {
        if (index == 5) {
            return false;
        }
        if (index + 1 > candidatesCount) {
            return false;
        }
        return true;
    }
    
    private Set<String> mergeAllCandidates() {
        Set<String> candiates = new HashSet<String>(mutual.getAllMutuals());
        candiates.addAll(visits.getAllVisitors());
        return candiates;
    }
    
    private Map<String, Integer> getCandidatePoints(Set<String> candidates) {
        Map<String, Integer> candidatePoints = new HashMap<>();
        for (String candidate : candidates) {
            int mutualCount = mutual.getTotalMutualCounts(candidate);
            int visitCount = visits.getTotalVisitCounts(candidate);
            int point = mutualCount*10 + visitCount;
            candidatePoints.put(candidate, point);
        }
        return candidatePoints;
    }
    
    private List<Map.Entry<String, Integer>> sortCandidatesByPoint(Map<String, Integer> candidatePoints) {
        List<Map.Entry<String, Integer>> candidates = new ArrayList<>(candidatePoints.entrySet());
        Collections.sort(candidates, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * (-1);
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });
        return candidates;
    }
}
