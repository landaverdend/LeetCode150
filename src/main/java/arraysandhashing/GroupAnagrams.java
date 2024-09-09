package arraysandhashing;

import common.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static String countAndSerialize(String str) {
       StringBuilder toRet = new StringBuilder();
       int[] counts = new int[26];

       for (char c : str.toLowerCase().toCharArray()) {
           int ind = c - 'a';
           counts[ind]++;
       }

       Character c = 'a';
       for (int i = 0; i < counts.length; i++) {
           toRet.append(c.toString() + counts[i]);
           c++; // inc alongside i
       }

       return toRet.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> toRet = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        // Idea: Serialize the string into a String of it's counts so that we can hash it
        for (String str : strs) {
            String key = countAndSerialize(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        for (List<String> list : map.values()) {
           toRet.add(list);
        }
        return toRet;
    }

    public static void main(String[] args) throws URISyntaxException {
        File file = FileHelper.getFile("groupanagrams.in");

        List<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<List<String>> solution = groupAnagrams(input.toArray(new String[0]));
        System.out.println(solution);
    }
}
