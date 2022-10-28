package onboarding.problem7;

public class ScoreInfo implements Comparable<ScoreInfo> {

    String id;
    int score;

    public ScoreInfo(String id,int score) {
        this.id = id;
        this.score = score;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public int compareTo(ScoreInfo o) {
        if(this.score==o.score){
            return this.id.compareTo(o.id);
        }

        return Integer.compare(o.score, this.score);
    }
}

