import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * Project name(项目名称)：字节流
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/18
 * Time(创建时间)： 22:27
 * Version(版本): 1.0
 * Description(描述)：
 * 字节输入流
 * InputStream 类及其子类的对象表示字节输入流，InputStream 类的常用子类如下。
 * ByteArrayInputStream 类：将字节数组转换为字节输入流，从中读取字节。
 * FileInputStream 类：从文件中读取数据。
 * PipedInputStream 类：连接到一个 PipedOutputStream（管道输出流）。
 * SequenceInputStream 类：将多个字节输入流串联成一个字节输入流。
 * ObjectInputStream 类：将对象反序列化。
 * 使用 InputStream 类的方法可以从流中读取一个或一批字节
 * InputStream类的常用方法
 * 方法名及返回值类型	        说明
 * int read()	从输入流中读取一个 8 位的字节，并把它转换为 0~255 的整数，最后返回整数。
 * 如果返回 -1，则表示已经到了输入流的末尾。为了提高 I/O 操作的效率，建议尽量
 * 使用 read() 方法的另外两种形式
 * int read(byte[] b)	从输入流中读取若干字节，并把它们保存到参数 b 指定的字节数组中。 该方法返回
 * 读取的字节数。如果返回 -1，则表示已经到了输入流的末尾
 * int read(byte[] b, int off, int len)	从输入流中读取若干字节，并把它们保存到参数 b 指定的字节数组中。其中，off 指
 * 定在字节数组中开始保存数据的起始下标；len 指定读取的字节数。该方法返回实际
 * 读取的字节数。如果返回 -1，则表示已经到了输入流的末尾
 * void close()	关闭输入流。在读操作完成后，应该关闭输入流，系统将会释放与这个输入流相关
 * 的资源。注意，InputStream 类本身的 close() 方法不执行任何操作，但是它的许多子类重写了 close() 方法
 * int available()	返回可以从输入流中读取的字节数
 * long skip(long n)	从输入流中跳过参数 n 指定数目的字节。该方法返回跳过的字节数
 * void mark(int readLimit)	在输入流的当前位置开始设置标记，参数 readLimit 则指定了最多被设置标记的字节数
 * boolean markSupported()	判断当前输入流是否允许设置标记，是则返回 true，否则返回 false
 * void reset()	将输入流的指针返回到设置标记的起始处
 * 字节输出流
 * OutputStream 类及其子类的对象表示一个字节OutputStream 类的常用方法
 * 方法名及返回值类型	说明
 * void write(int b)	向输出流写入一个字节。这里的参数是 int 类型，但是它允许使用表达式，
 * 而不用强制转换成 byte 类型。为了提高 I/O 操作的效率，建议尽量使用
 * write() 方法的另外两种形式
 * void write(byte[] b)	把参数 b 指定的字节数组中的所有字节写到输出流中
 * void write(byte[] b,int off,int len)	把参数 b 指定的字节数组中的若干字节写到输出流中。其中，off 指定字节
 * 数组中的起始下标，len 表示元素个数
 * void close()	关闭输出流。写操作完成后，应该关闭输出流。系统将会释放与这个输出
 * 流相关的资源。注意，OutputStream 类本身的 close() 方法不执行任何操
 * 作，但是它的许多子类重写了 close() 方法
 * void flush()	为了提高效率，在向输出流中写入数据时，数据一般会先保存到内存缓冲
 * 区中，只有当缓冲区中的数据达到一定程度时，缓冲区中的数据才会被写
 * 入输出流中。使用 flush() 方法则可以强制将缓冲区中的数据写入输出流，
 * 并清空缓冲区输出流。OutputStream 类的常用子类如下。
 * ByteArrayOutputStream 类：向内存缓冲区的字节数组中写数据。
 * FileOutputStream 类：向文件中写数据。
 * PipedOutputStream 类：连接到一个 PipedlntputStream（管道输入流）。
 * ObjectOutputStream 类：将对象序列化。
 * 字节数组输入流
 * ByteArrayInputStream 类可以从内存的字节数组中读取数据，该类有如下两种构造方法重载形式。
 * ByteArrayInputStream(byte[] buf)：创建一个字节数组输入流，字节数组类型的数据源由参数 buf 指定。
 * ByteArrayInputStream(byte[] buf,int offse,int length)：创建一个字节数组输入流，
 * 其中，参数 buf 指定字节数组类型的数据源，offset 指定在数组中开始读取数据的起始下标位置，length 指定读取的元素个数。
 * 字节数组输出流
 * ByteArrayOutputStream 类可以向内存的字节数组中写入数据，该类的构造方法有如下两种重载形式。
 * ByteArrayOutputStream()：创建一个字节数组输出流，输出流缓冲区的初始容量大小为 32 字节。
 * ByteArrayOutputStream(int size)：创建一个字节数组输出流，输出流缓冲区的初始容量大小由参数 size 指定。
 * ByteArrayOutputStream 类中除了有前面介绍的字节输出流中的常用方法以外，还有如下两个方法。
 * intsize()：返回缓冲区中的当前字节数。
 * byte[] toByteArray()：以字节数组的形式返回输出流中的当前内容。
 */

public class test
{
    public static void main(String[] args)
    {
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));
        byte[] b = new byte[]{1, -1, 25, -22, -5, 23}; // 创建数组
        ByteArrayInputStream bais = new ByteArrayInputStream(b, 0, 6); // 创建字节数组输入流
        int i = bais.read(); // 从输入流中读取下一个字节，并转换成int型数据
        while (i != -1)
        { // 如果不返回-1，则表示没有到输入流的末尾
            System.out.println("原值=" + (byte) i + "\t\t\t转换为int类型=" + i);
            i = bais.read(); // 读取下一个
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b1 = new byte[]{1, -1, 25, -22, -5, 23}; // 创建数组
        baos.write(b1, 0, 6); // 将字节数组b中的前4个字节元素写到输出流中
        System.out.println("数组中一共包含：" + baos.size() + "字节"); // 输出缓冲区中的字节数
        byte[] newByteArray = baos.toByteArray(); // 将输出流中的当前内容转换成字节数组
        System.out.println(Arrays.toString(newByteArray)); // 输出数组中的内容

        fileStream.main(null);
    }
}
