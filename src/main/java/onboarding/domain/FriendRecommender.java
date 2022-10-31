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
    private final Map<String, Integer> entryDict;
    
    public FriendRecommender(MutualDictionary mutualDict, VisitsDictionary visitsDict) {
        this.mutualDict = mutualDict;
        this.visitsDict = visitsDict;
        this.entryDict = getEntryDictionary(mergeAllEntries());
    }
    
    public List<String> getRecommendList() {
        List<String> list = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = getSortedEntries(entryDict);
        int idx = 0;
        while (!(idx == 5 || idx + 1 > entryList.size())) {
            Map.Entry<String, Integer> entry = entryList.get(idx);
            list.add(entry.getKey());
            idx++;
        }
        return list;
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
}
