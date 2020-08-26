package FileOpeartionUtils;

import java.io.File;
import java.util.ArrayList;

public class DeleteFile {

    private ArrayList<String> typeList;//类型列表

    /**
     * 删除文件通过类型不符合
     *
     * @param type 文件列表
     * @param path 文件类型
     */
    public void deleteFileByType(String type, String path) {
        //1.获取目标路径下所有的文件
        ArrayList<File> files = new ListAll().getAll(path);
        //2.循环遍历删除不符合的文件
        for (File file : files) {
            if (!getFileType(file).equals(type)) {
                file.delete();
            }
        }
    }

    /**
     * @param list 文件列表
     * @param type 文件类型
     */
    public void deleteFileByType(ArrayList<File> list, String type) {
        for (File file : list) {
            if (!getFileType(file).equals(type)) {
                file.delete();
            }
        }
    }

    /**
     * 获取文件类型
     *
     * @param file
     * @return file type
     */
    public String getFileType(File file) {
        String name = file.getName();
        return name.substring(name.lastIndexOf(".") + 1, name.length());
    }

}
