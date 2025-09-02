
import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    HashMap<String, ArrayList<EmotionEntry>> hash;

    public TimeMap() {
        hash = new HashMap<>();
    }

public void set(String key, String value, int timestamp) {
    ArrayList<EmotionEntry> entries = hash.get(key);

    if(entries == null){
        entries = new ArrayList<>();
        hash.put(key, entries);
    }

    entries.add(new EmotionEntry(value, timestamp));
}

public String get(String key, int timestamp) {
    ArrayList<EmotionEntry> entries = hash.get(key);

    if(entries == null){
        return "";
    }

    int l = 0;
    int r = entries.size() - 1;
    String closestEmotion = "";

    while(l<=r){
        int mid = (l + r)/2;
        EmotionEntry entry = entries.get(mid);

        if(entry.timestamp == timestamp){
            return entry.emotion;
        }
        else if(entry.timestamp > timestamp){
            r = mid-1;
        }
        else{
            l = mid + 1;
            closestEmotion = entry.emotion;
        }
    }

    return closestEmotion;
}

private class EmotionEntry{
    private String emotion;
    private int timestamp;

    public EmotionEntry(String emotion, int timestamp){
        this.emotion = emotion;
        this.timestamp = timestamp;
    }

    public String getEmotion(){
        return this.emotion;
    }

    public int getTimestamp(){
        return this.timestamp;
    }
}
}
