package common;

import arraysAndHashing.GroupAnagrams;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileHelper {
    public static File getFile(String filename) throws URISyntaxException {
        URL resource = GroupAnagrams.class.getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            return new File(resource.toURI());
        }

    }
}
