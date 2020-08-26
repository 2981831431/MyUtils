package FileOpeartionUtils;

import java.io.File;


public class DeleteEmptyDir {


    /**
     * 删除该目录下所有空文件夹
     *
     * @param root 根目录
     */
    public static void operationDelete(File root) {
        //1.判断文件是否为文件夹
        if (root.isDirectory()) {
            //2.判断是否是空文件夹
            if (root.listFiles().length == 0) {
                //2.1为空删除
                root.delete();
            } else {
                //2.2不为空递归判断删除
                File[] files = root.listFiles();
                for (File f : files) {
                    operationDelete(f);
                }
                //3.递归删除结束，查看根文件夹是否是空文件夹
                if (root.listFiles().length == 0) {
                    root.delete();
                }
            }
        }
    }
}
