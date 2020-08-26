import EncryptionUtils.MD5;
import FileOpeartionUtils.*;
import org.apache.commons.io.FileUtils;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Test {


    public static void main(String[] args) throws Exception {

/*        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (end - begin) + "ms");*/

        System.out.println(new MD5().getPassword(10));

    }
}
