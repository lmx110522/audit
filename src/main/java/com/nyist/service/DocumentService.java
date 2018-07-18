package com.nyist.service;

import com.nyist.pojo.Document;
import com.nyist.pojo.DocumentList;
import com.nyist.result.NyistResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13/013.
 */
public interface DocumentService {
    NyistResult fileupload(List<MultipartFile> files, DocumentList documentList);
}
