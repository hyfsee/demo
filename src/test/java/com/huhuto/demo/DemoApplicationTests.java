package com.huhuto.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Test
    void contextLoads() throws IOException {

        // 获得网页的document对象
        Document parse = Jsoup.parse(new URL("http://www.baidu.com/"), 1000 * 10);
//        // 爬取含图片的代码部分
//        Element content = document.getElementById("js_content");
//        // 获取img标签代码  这是个集合
//        Elements imgs = content.getElementsByTag("img");
//        // 命名图片的id
//        int id=0;
//        for (Element img : imgs) {
//            // 获取具体的图片
//            String pic = img.attr("data-src");
//            URL target = new URL(pic);
//            // 获取连接对象
//            URLConnection urlConnection = target.openConnection();
//            // 获取输入流，用来读取图片信息
//            InputStream inputStream = urlConnection.getInputStream();
//            // 获取输出流  输出地址+文件名
//            id++;
//            FileOutputStream fileOutputStream = new FileOutputStream("E:\\JsoupPic\\" + id + ".png");
//
//            int len=0;
//            // 设置一个缓存区
//            byte[] buffer = new byte[1024 * 1024];
//            // 写出图片到E:\JsoupPic中,  输入流读数据到缓冲区中，并赋给len
//            while ((len=inputStream.read(buffer))>0){
//                // 参数一：图片数据  参数二：起始长度  参数三：终止长度
//                fileOutputStream.write(buffer, 0, len);
//            }
//            System.out.println(id+".png下载完毕");
//            // 关闭输入输出流 最后创建先关闭
//            fileOutputStream.close();
//            inputStream.close();
//        }
        System.out.println(parse);

    }

}
