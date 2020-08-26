package FileOpeartionUtils;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.*;
import java.util.ArrayList;

public class FileAvoidHarmony {
    /**
     * 文件防和谐
     * 方式：改名
     * 为了避免有些内容被和谐，通过一定规则的改名
     * 把原本的文件名记录下来，然后保存，以便于再次恢复
     * <p>
     * 默认把保存的文件命名为a.txt
     * 使用时，可以根据需求自定义文件名字
     */

    private ArrayList<String> nameList;//文件名列表
    private String fileName = "a";//保存文件名文件的文件名
    private String fileType = ".txt";//保存文件名文件的类型


    public FileAvoidHarmony(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
        nameList = new ArrayList<String>();
    }


    public FileAvoidHarmony() {
        nameList = new ArrayList<String>();
    }

    /**
     * 把文件名记录录下来并保存，然后把保存下来的内容存储在文件中
     *
     * @param file 根目录
     * @throws IOException
     */
    public void record(File file) throws IOException {
        //1.判断是否是文件夹，不是则直接结束
        if (file.isDirectory()) {
            //2.列出文件列表
            File[] files = file.listFiles();
            int i = 1;
            //3.便利文件列表获取文件名
            for (File f : files) {
                OperationFileName.changeAllName(f, i + "");
                nameList.add(f.getName().substring(0, f.getName().lastIndexOf(".")));
                i++;
            }
            //4.把获取到的文件名写入文件
            writeFile(file);
        }
    }

    /**
     * 把记录好的名字，存储到列表中
     *
     * @param root 根目录
     * @throws IOException
     */
    private void writeFile(File root) throws IOException {
        if (root.isDirectory()) {
            File file = new File(root + "\\" + fileName + fileType);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            int i = 1;
            for (String s : nameList) {
                writer.write(i + "" + "\t" + nameList.get(i - 1));
                writer.write("\r\n");
                i++;
            }
            writer.close();
        }
    }


    /**
     * 读取相应保存文件名的文件，按照顺序修改文件名
     * 修改之后，会自动删除存有文件名的文件
     *
     * @param root 根目录
     * @throws IOException
     */
    public void reduction(File root) throws IOException {
        if (root.isDirectory()) {
            readFile(root);
            File[] files = root.listFiles();
            int i = 0;
            for (File f : files) {
                if (!f.getName().equals(fileName + fileType)) {
                    OperationFileName.changeAllName(f, nameList.get(i));
                    i++;
                }
            }
            File file = new File(root.getPath() + "\\" + fileName + fileType);
            file.delete();
        }
    }

    /**
     * 读取保存文件名的文件，保存在文件名列表中
     *
     * @param root 根目录
     * @throws IOException
     */
    private void readFile(File root) throws IOException {
        if (root.isDirectory()) {
            File file = new File(root.getPath() + "\\" + fileName + fileType);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                String[] split = s.split("\t");
                nameList.add(split[1]);
            }
            br.close();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
