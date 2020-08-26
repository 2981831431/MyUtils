package FileOpeartionUtils;

import java.io.File;

public class MovieFile {

    public enum WPS {eight, length, seven, six}


    public static boolean moveFile(String fileRoute, String path) {
        File file = new File(fileRoute);
        boolean b = file.renameTo(new File(path + "\\" + file.getName()));
        return b;
    }
}
