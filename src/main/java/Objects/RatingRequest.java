package Objects;

/**
 * Created by derekhsieh on 4/6/16.
 */
public class RatingRequest {
    private String username;
    private String friend;
    private Float rating;
    private long updated;

    public RatingRequest(String username, String friend, Float rating, long updated) {
        this.username = username;
        this.friend = friend;
        this.rating = rating;
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
