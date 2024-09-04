package binarySearch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tuple {

    String val;
    int ts;

    Tuple (String val, int ts) {
        this.val = val;
        this.ts = ts;
    }
}

public class TimeMap {
    public Map<String, List<Tuple>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (map.get(key) == null) map.put(key, new ArrayList<Tuple>());

        map.get(key).add(new Tuple(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (map.get(key) == null) return "";

        List<Tuple> arr = map.get(key);

        String toRet = "";
        int l = 0, r = arr.size() - 1;

        while (l <= r) {
            int m = (r - l) / 2 + l;

            if (arr.get(m).ts <= timestamp) {
                l = m + 1;
                toRet = arr.get(m).val;
            }
            else {
                r = m - 1;
            }
        }

        return toRet;
    }
}
