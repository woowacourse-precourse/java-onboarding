package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem7 {

    public static List<String> makeUserListByRecommendation(){
        List<String> result = Collections.emptyList();
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private class SocialGraph {
        private List<Entry> orderedList;
        private List<String> users;
        private EntryComparator cmp;
        public SocialGraph(List<List<String>> friends) {
//            Collections.sort(orderedList);
        }

    }

    private class Entry implements Comparable<Entry>  {
        protected String name = "";
        protected int recommendationValue = 0;

        protected Entry(String sname, int value){
            this.name = sname;
            this.recommendationValue = value;
        }

        @Override
        public int compareTo(Entry o) {
            int tmp = this.name.compareTo( o.name);
            if( tmp > 0){
                return -1;
            }else if (tmp < 0){
                return 1;
            }
            return 0;
        }
        public boolean equals(Entry o){
            return this.name.equals(o.name);
        }
    }
    private class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return (o1.recommendationValue - o2.recommendationValue);
        }
    }
}
