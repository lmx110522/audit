package com.nyist.service;

import com.nyist.pojo.Document;
import com.nyist.pojo.DocumentList;
import com.nyist.pojo.UserModule;
import com.nyist.repository.DocumentRepository;
import com.nyist.repository.ModuleRepository;
import com.nyist.repository.TUserRepository;
import com.nyist.repository.UserModuleRepository;
import com.nyist.result.NyistResult;
import com.nyist.utils.Doc2HtmlUtil;
import com.nyist.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private TUserRepository tUserRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    UserModuleRepository userModuleRepository;
    @Override
    public NyistResult fileupload(List<MultipartFile> files, DocumentList documentList) {
        List<Document> documents=documentList.getDocumentList();
        for(int i=0;i<files.size();i++) {
            if (!files.get(i).isEmpty()) {
                try {
                    String oldname = files.get(i).getOriginalFilename();
                    //文件上传
                    FtpUtil.uploadFile(host, port, username, password, basePath
                            , oldname, files.get(i).getInputStream());
                    Document document=documents.get(0);
                    //调用Doc2HtmlUtil工具类
               /* Doc2HtmlUtil coc2HtmlUtil = Doc2HtmlUtil.getDoc2HtmlUtilInstance();
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
                coc2HtmlUtil.file2pdf(fileInputStream, "D:/ss", substring, fileOtherName);*/
               document.setDname(oldname);
               document.setFileUrl(fileUrl+"/"+oldname);
               document.setIsOk(1);
               document.setUpdateTime(new Timestamp(new Date().getTime()));
               document.setModuleByMid(moduleRepository.findModuleById(document.getModuleByMid().getId()));
               document.settUserByUid(tUserRepository.findTUserById(document.gettUserByUid().getId()));
               documentRepository.save(document);     //添加文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //添加教研室上传信息
        for (Document document:documents){
            UserModule userModule=new UserModule();
            userModule.setModuleByMid(document.getModuleByMid());
            userModule.settUserByTuid(document.gettUserByUid());
            userModule.setIsOk(0);
            userModuleRepository.save(userModule);
        }
        return NyistResult.ok();
    }
}
