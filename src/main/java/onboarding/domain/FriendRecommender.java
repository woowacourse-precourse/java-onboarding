package onboarding.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FriendRecommender {
    private final MutualDictionary mutualDict;
    private final VisitsDictionary visitsDict;
    
    public FriendRecommender(MutualDictionary mutualDict, VisitsDictionary visitsDict) {
        this.mutualDict = mutualDict;
        this.visitsDict = visitsDict;
    }
    
    public List<String> getRecommendList() {
        Set<String> totalEntries = mergeAllEntries();
        Map<String, Integer> entryDict = getEntryDictionary(totalEntries);
        List<Map.Entry<String, Integer>> list = getSortedEntries(entryDict);
        return getTop5Entries(list);
    }
    
    private Set<String> mergeAllEntries() {
        Set<String> entries = new HashSet<String>(mutualDict.getAllMutuals());
        entries.addAll(visitsDict.getAllVisitors());
        return entries;
    }
    
    private Map<String, Integer> getEntryDictionary(Set<String> entries) {
        Map<String, Integer> entryDict = new HashMap<>();
        for (String entry : entries) {
            int mutualCnt = mutualDict.getTotalMutualCounts(entry);
            // TODO 방문자 중 친구인 경우는 visitsDictionary에서 미리 제외하고 있는데, 여기서 제외하는 게 나을지?
            int visitCnt = visitsDict.getTotalVisitCounts(entry);
            int point = mutualCnt*10 + visitCnt;
            entryDict.put(entry, point);
        }
        return entryDict;
    }
    
    private List<Map.Entry<String, Integer>> getSortedEntries(Map<String, Integer> dictionary) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(dictionary.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * (-1);
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });
        return list;
    }
    
    private List<String> getTop5Entries(List<Map.Entry<String, Integer>> entryList) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        while (!(idx == 5 || idx + 1 > entryList.size())) {
            Map.Entry<String, Integer> entry = entryList.get(idx);
            list.add(entry.getKey());
            idx++;
        }
        return list;
    }
}
