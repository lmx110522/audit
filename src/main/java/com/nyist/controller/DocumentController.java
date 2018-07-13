package com.nyist.controller;

import com.nyist.utils.Doc2HtmlUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Administrator on 2018/7/13/013.
 */

@Controller
@RequestMapping("/document")
public class DocumentController {

    @RequestMapping(value="/upoload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。


                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream("D:/pdf/"+file.getOriginalFilename()));
                System.out.println(file.getOriginalFilename());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            //调用Doc2HtmlUtil工具类
            Doc2HtmlUtil coc2HtmlUtil = Doc2HtmlUtil.getDoc2HtmlUtilInstance();
            File file1 = null;
            FileInputStream fileInputStream = null;
            //这里写的是被转文件的路径
            file1 = new File("D:/pdf/"+file.getOriginalFilename());

            fileInputStream = new FileInputStream(file1);

//为了后期方便，这里直接把文件名进行了截取，方便后续操作
            int i = file.getOriginalFilename().lastIndexOf(".");
            String substring = file.getOriginalFilename().substring(i);
            int num=substring.length();//得到后缀名长度

            String fileOtherName=file.getOriginalFilename().substring(0, file.getOriginalFilename().length()-num);//得到文件名。去掉了后缀
            //上述的所有路径以及以下路劲均可自定义
            coc2HtmlUtil.file2pdf(fileInputStream,"D:/ss",substring,fileOtherName);
            Doc2HtmlUtil doc = new Doc2HtmlUtil();     //后期数据处理


            return "上传成功";


        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
