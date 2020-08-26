package FileOpeartionUtils;

import java.io.File;
import java.util.ArrayList;

public class OperationFileName {

    /**
     * 操作文件名相关
     * 1.获取目标文件夹下的文件
     * 2.或者文件单个目标
     * 3.修改文件名，对文件名进行操作
     */

    //文件插入位置
    public static int end = 0;//末尾，后缀名之前
    public static int start = 1;//文件名最前


    /**
     * 修改文件名中的某些字段
     *
     * @param files  文件数组
     * @param target 要修改的内容
     * @param result 修改之后的内容
     */
    public static void change(File[] files, String target, String result) {
        for (File file : files) {
            boolean b = file.renameTo(
                    new File(file.getParent() + "\\" +
                            file.getName().replace(target, result)));
        }
    }

    /**
     * 修改文件名中的某些字段
     *
     * @param files  文件数组
     * @param target 要修改的内容
     * @param result 修改之后的内容
     */
    public static void change(ArrayList<File> files, String target, String result) {
        for (File file : files) {
            boolean b = file.renameTo(
                    new File(file.getParent() + "\\" +
                            file.getName().replace(target, result)));
        }
    }


    /**
     * 在文件中最前面或者最后面添加字段
     *
     * @param files    文件数组
     * @param str      要添加的内容
     * @param position 要插入的位置
     */
    public static void add(File[] files, String str, int position) {
        for (File file : files) {
            operationAdd(file, str, position);
        }
    }

    public static void add(ArrayList<File> files, String str, int position) {
        for (File file : files) {
            operationAdd(file, str, position);
        }
    }

    /**
     * 单个文件增加内容
     *
     * @param file     文件
     * @param str      添加的内容
     * @param position 要插入的位置
     */
    public static void operationAdd(File file, String str, int position) {
        String name = file.getName();
        if (position == start) {
            boolean b = file.renameTo(
                    new File(file.getParent() + "\\" +
                            str + name));
        } else if (position == end) {
            boolean b = file.renameTo(
                    new File(file.getParent() + "\\" +
                            name.substring(0, name.lastIndexOf(".")) + str +
                            name.substring(name.lastIndexOf("."), name.length())));
        }
    }

    /**
     * 批量修改文件类型
     *
     * @param files
     * @param newType
     */
    public static void changeType(File[] files, String newType) {
        for (File file : files) {
            file.renameTo(
                    new File(file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf(".")
                    ) + "." + newType));
        }
    }


    /**
     * 修改文件的全名
     *
     * @param file 文件
     * @param str  要修改的名字
     */
    public static void changeAllName(File file, String str) {
        boolean b = file.renameTo(new File(
                file.getParent() + "\\"
                        + str + file.getName().substring(file.getName().lastIndexOf("."), file.getName().length())
        ));
    }
}
