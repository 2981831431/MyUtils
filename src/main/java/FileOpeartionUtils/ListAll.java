package FileOpeartionUtils;

import java.io.File;
import java.util.ArrayList;

public class ListAll {

    /**
     * 批量获取文件，筛选文件等获取多个文件
     */

    public ArrayList<File> list;

    public ListAll() {

    }

    /**
     * 获取目标文件夹下的所有文件和文件夹
     * 如果输入的文件夹，则返回所有文件
     * 如果输入文件，则返回单个文件的数组
     *
     * @param path
     * @return file array / null
     */
    public File[] getDirFiles(String path) {
        File file = new File(path);
        if (file.isDirectory())
            return file.listFiles();
        else if (file.isFile()) {
            File[] list = new File[1];
            list[0] = file;
            return list;
        }
        return null;
    }

    /**
     * 函数调用
     * 获取该目录下所有的文件，如果有文件夹就一直往下寻找
     * 知道全部找到位置
     *
     * @param path
     * @return file list
     */
    public ArrayList<File> getAll(String path) {
        //节省空间，使用的时候在实例化
        list = new ArrayList<File>();
        getFiles(new File(path));
        return list;
    }

    /**
     * 递归查找所有文件，遇到文件夹则继续深入
     * 遇到文件存储到 Arraylist中
     * 配合 getAll函数使用
     *
     * @param file
     */
    private void getFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                getFiles(file1);
            }
        } else if (file.isFile()) {
            list.add(file);
        }
    }


    /**
     * 列出该目录下所有的文件路径
     *
     * @param path
     */
    public void ListFiles(String path) {
        getFiles(new File(path));
        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
    }


    public ArrayList<File> getDir(String path) {
        //节省空间，使用的时候在实例化
        list = new ArrayList<File>();
        ListAllDir(new File(path));
        return list;
    }


    private void ListAllDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            list.add(file);
            for (File f : files) {
                ListAllDir(f);
            }
        }
    }
}
