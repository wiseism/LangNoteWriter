package cn.wdidada.test.langnotewriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.print.attribute.standard.Copies;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * 测试io工具包
 * 本人英语水平不过关,简单理解下
 * (注释的第一行是测试的方法,第二行是官方文档的解释,第三行是我测试做的结论)
 * @author WZLOVE
 * @create 2018-04-30 12:30
 */
public class Main {

    public static void main(String[] args) {
        String path = "H:\\javaTest\\iotest";
        String path1 = "H:\\javaTest\\iotest\\1.txt";
        String path2 = "H:\\javaTest\\iotest\\2.txt";
        String path3 = "H:\\MyTest";
        String path4 = "H:\\MyTest\\test";
        File file = new File(path);
        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);
        File file4 = new File(path4);
        FileUtils fu = new FileUtils();

        // 复制操作

        //     cleanDirectory(File directory)
        // Cleans a directory without deleting it.
        // 删除该文件夹下的所有东西(如果该路径是文件或者路径不存在是会报java.lang.IllegalArgumentException异常)
        try {
            FileUtils.cleanDirectory(file);
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // contentEquals(File file1, File file2)
        // Compares the contents of two files to determine if they are equal or not.
        // 测试两个文件的内容相不相同
        try {
            System.out.println(FileUtils.contentEquals(file1,file2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copyDirectory(File srcDir, File destDir)
        // Copies a whole directory to a new location preserving the file dates.
        // 复制第一个参数的文件夹下的所有内容复制到第二个参数的文件夹下
        try {
            FileUtils.copyDirectory(file,file3);
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //     copyDirectoryToDirectory(File srcDir, File destDir)
        //  Copies a directory to within another directory preserving the file dates.
        // 将第一个参数的整个文件夹(即iotest文件夹)复制到第二个路径下
        try {
            FileUtils.copyDirectoryToDirectory(file, file3);
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //     copyFile(File srcFile, File destFile)
        //  Copies a file to a new location preserving the file date.
        //  将一个文件的内容复制到另一个文件中
        try {
            FileUtils.copyFile(file1, file2);
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copyFileToDirectory(File srcFile, File destDir)
        // Copies a file to a directory preserving the file date.
        // 将一个文件复制到另一个文件夹下(不做测试了)

        System.out.println("==================================================");

        // 读写操作

        //     readFileToString(File file, String encoding)
        //  Reads the contents of a file into a String.
        //  读取文件内容返回String,原样输出
        try {
            String str = FileUtils.readFileToString(file1, "UTF-8");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // readLines(File file, String encoding)
        // Reads the contents of a file line by line to a List of Strings.
        // 返回String集合
        try {
            List<String> strList = FileUtils.readLines(file1, "UTF-8");
            for (String s : strList) {
                System.out.println(s);
            }
            System.out.println(strList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // writeStringToFile(File file, String data, String encoding)
        // Writes a String to a file creating the file if it does not exist.
        // 将String数据写入文件(只能输入一行,如果后续还有输入,将覆盖前面的内容,下一个方法将是追加)
        try {
            Scanner in = new Scanner(System.in);
            while (true){
                System.out.println("请输入内容(结束请输入break):");
                String str = in.nextLine();
                if(!str.equals("break")){
                    FileUtils.writeStringToFile(file2, str, "UTF-8");
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // writeStringToFile(File file, String data, String encoding, boolean append)
        // Writes a String to a file creating the file if it does not exist.
        // 将String数据写入文件,多个string数据就追加(记住一点文件里不会换行)
        try {
            Scanner in = new Scanner(System.in);
            while (true){
                System.out.println("请输入内容(结束请输入break):");
                String str = in.nextLine();
                if(!str.equals("break")){
                    FileUtils.writeStringToFile(file2, str, "UTF-8",true);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("============================================");
        // 网络相关

        // copyURLToFile(URL source, File destination)
        // Copies bytes from the URL source to a file destination.
        // 获取一个网页的源代码,写入本地文件,还可以向本地写图片的等等
        // 下面是两个例子,一个获取页面,一个获取图片(如果文件不存在会自动创建)
        try {
            FileUtils.copyURLToFile(new URL("https://blog.csdn.net/lixin2302007/article/details/78354929"),
                    new File("H:\\javaTest\\iotest\\test.html"));
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 写图片
        try {
            FileUtils.copyURLToFile(new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525082437668&di=18d455af6f3ffedc1f4d2e022cfe4af5&imgtype=0&src=http%3A%2F%2Fpic.eastlady.cn%2Fuploads%2Ftp%2F201705%2F9999%2F7e03b578dc.jpg"),
                    new File("H:\\javaTest\\iotest\\1.jpg"));
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
