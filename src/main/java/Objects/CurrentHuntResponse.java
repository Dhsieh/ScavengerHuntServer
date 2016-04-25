package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekhsieh on 4/22/16.
 */
public class CurrentHuntResponse {
    private List<String> toRate;
    private List<String> toSend;
    private List<String> toSee;

    public CurrentHuntResponse(){
        toRate = new ArrayList<>();
        toSend = new ArrayList<>();
        toSee = new ArrayList<>();
    }

    public CurrentHuntResponse(List<String> toRate, List<String> toSend, List<String> toSee) {
        this.toRate = toRate;
        this.toSend = toSend;
        this.toSee = toSee;
    }

    public List<String> getToRate() {
        return toRate;
    }

    public void setToRate(List<String> toRate) {
        this.toRate = toRate;
    }

    public List<String> getToSend() {
        return toSend;
    }

    public void setToSend(List<String> toSend) {
        this.toSend = toSend;
    }

    public List<String> getToSee() {
        return toSee;
    }

    public void setToSee(List<String> toSee) {
        this.toSee = toSee;
    }

    public void addToRate(String friend){
        toRate.add(friend);
    }

    public void addToSend(String friend){
        toSend.add(friend);
    }

    public void addToSee(String friend){
        toSee.add(friend);
    }

    public boolean isEmpty(){
        return toSee.isEmpty() && toSend.isEmpty() && toRate.isEmpty();
    }
}
