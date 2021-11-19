import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Project name(项目名称)：test.java
 * Package(包名): PACKAGE_NAME
 * Class(类名): fileStream
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/19
 * Time(创建时间)： 21:52
 * Version(版本): 1.0
 * Description(描述)：
 * 文件输入流
 * FileInputStream 是 Java 流中比较常用的一种，它表示从文件系统的某个文件中获取输入字节。
 * 通过使用 FileInputStream 可以访问文件中的一个字节、一批字节或整个文件。
 * 在创建 FileInputStream 类的对象时，如果找不到指定的文件将拋出 FileNotFoundException 异常，该异常必须捕获或声明拋出。
 * FileInputStream 常用的构造方法主要有如下两种重载形式。
 * FileInputStream(File file)：通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
 * FileInputStream(String name)：通过打开一个到实际文件的链接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。
 * <p>
 * 文件输出流
 * FileOutputStream 类继承自 OutputStream 类，重写和实现了父类中的所有方法。FileOutputStream 类的对象表示一个文件字节输出流，
 * 可以向流中写入一个字节或一批字节。在创建 FileOutputStream 类的对象时，如果指定的文件不存在，则创建一个新文件；如果文件已存在，则清除原文件的内容重新写入。
 * FileOutputStream 类的构造方法主要有如下 4 种重载形式。
 * FileOutputStream(File file)：创建一个文件输出流，参数 file 指定目标文件。
 * FileOutputStream(File file,boolean append)：创建一个文件输出流，参数 file 指定目标文件，
 * append 指定是否将数据添加到目标文件的内容末尾，如果为 true，则在末尾添加；如果为 false，则覆盖原有内容；其默认值为 false。
 * FileOutputStream(String name)：创建一个文件输出流，参数 name 指定目标文件的文件路径信息。
 * FileOutputStream(String name,boolean append)：创建一个文件输出流，参数 name 和 append 的含义同上。
 * 在 FileOutputStream 类的构造方法中指定目标文件时，目标文件可以不存在。
 * 目标文件的名称可以是任意的，例如 D:\\abc、D:\\abc.de 和 D:\\abc.de.fg 等都可以，可以使用记事本等工具打开并浏览这些文件中的内容。
 * 目标文件所在目录必须存在，否则会拋出 java.io.FileNotFoundException 异常。
 * 目标文件的名称不能是已存在的目录。例如 D 盘下已存在 Java 文件夹，那么就不能使用 Java 作为文件名，
 * 即不能使用 D:\\Java，否则抛出 java.io.FileNotFoundException 异常。
 */

@SuppressWarnings("all")
public class fileStream
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("file-test.txt");
            FileInputStream f1 = new FileInputStream(file);
            FileInputStream f2 = new FileInputStream("file-test.txt");
            int n = 0;
            byte[] bytes = new byte[1024];
            System.out.println("f1:");
            while ((n = f1.read(bytes)) != -1)
            {
                String s = new String(bytes, 0, n); // 将数组中从下标0到n的内容给s
                System.out.print(s);
            }
            System.out.println();
            System.out.println("f2:");
            while ((n = f2.read(bytes)) != -1)
            {
                String s = new String(bytes, 0, n); // 将数组中从下标0到n的内容给s
                System.out.print(s);
            }
            f1.close();
            f2.close();
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
        }
        catch (Exception e)
        {
            System.out.println("未知异常！！！");
            e.printStackTrace();
        }

        //输出
        File file1 = new File("test-out1.txt");
        FileOutputStream fOut1 = null;
        FileOutputStream fOut2 = null;
        FileOutputStream fOut3 = null;
        try
        {
            fOut1 = new FileOutputStream(file1);
            fOut2 = new FileOutputStream("test-out2.txt");
            fOut3 = new FileOutputStream("test-out3.txt", true);
            byte[] bytes = new byte[100];
            for (int i = 0; i < 100; i++)
            {
                bytes[i] = (byte) i;
            }
            fOut1.write(bytes);
            fOut2.write(bytes);
            fOut3.write(bytes);
            System.out.println();
            System.out.println("写入完成");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件无法创建");
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("其它错误");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fOut1 != null)
                {
                    fOut1.close();
                }
                if (fOut2 != null)
                {
                    fOut2.close();
                }
                if (fOut3 != null)
                {
                    fOut3.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        FileInputStream fin = null;
        FileInputStream fin1 = null;
        try
        {
            //------------------------------------------------------
            long startTime = System.nanoTime();   //获取开始时间
            //------------------------------------------------------
            fin = new FileInputStream("src\\main\\java\\test.java");
            int n = 0;
            byte[] bytes = new byte[1024];
            while ((n = fin.read(bytes)) != -1)
            {
                String s = new String(bytes, 0, n); // 将数组中从下标0到n的内容给s
                System.out.print(s);
            }
            System.out.println();
            fin1 = new FileInputStream("src\\main\\java\\fileStream.java");
            n = 0;
            while ((n = fin1.read(bytes)) != -1)
            {
                String s = new String(bytes, 0, n); // 将数组中从下标0到n的内容给
                System.out.print(s);
            }
            //------------------------------------------------------
            long endTime = System.nanoTime(); //获取结束时间
            if ((endTime - startTime) < 1000000)
            {
                double final_runtime;
                final_runtime = (endTime - startTime);
                final_runtime = final_runtime / 1000;
                System.out.println("算法运行时间： " + final_runtime + "微秒");
            }
            else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
            {
                double final_runtime;
                final_runtime = (endTime - startTime) / 1000;
                final_runtime = final_runtime / 1000;
                System.out.println("算法运行时间： " + final_runtime + "毫秒");
            }
            else
            {
                double final_runtime;
                final_runtime = (endTime - startTime) / 10000;
                final_runtime = final_runtime / 100000;
                System.out.println("算法运行时间： " + final_runtime + "秒");
            }
            Runtime r = Runtime.getRuntime();
            float memory;
            memory = r.totalMemory();
            memory = memory / 1024 / 1024;
            System.out.printf("JVM总内存：%.3fMB\n", memory);
            memory = r.freeMemory();
            memory = memory / 1024 / 1024;
            System.out.printf(" 空闲内存：%.3fMB\n", memory);
            memory = r.totalMemory() - r.freeMemory();
            memory = memory / 1024 / 1024;
            System.out.printf("已使用的内存：%.4fMB\n", memory);
            //------------------------------------------------------
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件未找到");
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("其它异常");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fin != null)
                {
                    fin.close();
                }
                if (fin1 != null)
                {
                    fin1.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
