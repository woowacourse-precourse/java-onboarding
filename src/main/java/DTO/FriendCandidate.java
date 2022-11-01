package DTO;

public class FriendCandidate implements Comparable<FriendCandidate>{
    private String id;
    private int score;

    public FriendCandidate(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(FriendCandidate o) {
        if(score == o.getScore()) return id.compareTo(o.getId());
        return o.getScore() - score;
    }
}
