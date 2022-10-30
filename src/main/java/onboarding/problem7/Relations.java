package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class Relations {
    private List<List<String>> relation;

    Relations(List<List<String>> relation) {
        this.relation = relation;
    }

    public int size() {
        return relation.size();
    }

    public List<String> getRelation(int index) {
        return relation.get(index);
    }
}
