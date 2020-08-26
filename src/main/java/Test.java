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

        ArrayList<File> files = new ListAll().getAll("E:\\ASMR\\before\\清软喵\\q1");
//        File[] files = new ListAllFile().getDirFiles("E:\\ASMR\\before\\清软喵\\q1\\视频");

        OperationFileName.change(files, "【如花视频-www.rhsp.pw】-", "");

        long end = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (end - begin) + "ms");*/

   /*     ArrayList<File> dir = new ListAll().getDir("E:\\ASMR\\before\\清软喵\\新建文件夹");

        for (File file : dir) {
            System.out.println(file.getPath() + "\t" + file.getName());
        }


        DeleteEmptyDir.operationDelete(new File("E:\\ASMR\\before\\清软喵\\新建文件夹"));
        */

    /*    File file = new File("D:\\迅雷下载\\91唐哥\\176.MOV");
        System.out.println(file.getName());*/


/*        FileAvoidHarmony fa = new FileAvoidHarmony();
        File file = new File("D:\\迅雷下载\\MD系列");
//        fa.record(file);

        fa.reduction(file);*/


     /*   FileAvoidHarmony name = new FileAvoidHarmony("fileName", ".txt");

        name.reduction(new File("H:\\视频\\电视剧\\下一站性福\\Video\\3D_Carton"));*/

        System.out.println(new MD5().getPassword(10));
        System.out.println("6666");
    }
}
