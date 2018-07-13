package com.nyist.service;

import com.nyist.result.NyistResult;
import com.nyist.utils.Doc2HtmlUtil;
import com.nyist.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/13/013.
 */

@Service
@Transactional
@PropertySource(value="classpath:ftpd.properties")
public class DocumentServiceImpl implements  DocumentService {
    @Value("${FTP_ADDRESS}")
    private String host;
    @Value("${FTP_PORT}")
    private int port;
    @Value("${FTP_USERNAME}")
    private String username;
    @Value("${FTP_PASSWORD}")
    private String password;
    @Value("${FTP_BASE_PATH}")
    private String basePath;
    @Value("${IMAGE_BASE_URL}")
    private String fileUrl;

    @Override
    public NyistResult fileupload(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String oldname = file.getOriginalFilename();
                //文件上传
                FtpUtil.uploadFile(host, port, username, password, basePath
                        , oldname, file.getInputStream());
                //调用Doc2HtmlUtil工具类
                Doc2HtmlUtil coc2HtmlUtil = Doc2HtmlUtil.getDoc2HtmlUtilInstance();
                File file1 = null;
                FileInputStream fileInputStream = null;
                //这里写的是被转文件的路径
                file1 = new File("D:/pdf/" + file.getOriginalFilename());

                fileInputStream = new FileInputStream(file1);
                //把文件名进行了截取，方便后续操作
                int i = file.getOriginalFilename().lastIndexOf(".");
                String substring = file.getOriginalFilename().substring(i);
                int num = substring.length();//得到后缀名长度
                String fileOtherName = file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - num);//得到文件名。去掉了后缀
                //上述的所有路径以及以下路劲均可自定义
                coc2HtmlUtil.file2pdf(fileInputStream, "D:/ss", substring, fileOtherName);
            } catch (IOException e) {

            }
        }
        return null;
    }
}
