package com.nyist.service;

import com.nyist.result.NyistResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2018/7/13/013.
 */
public interface DocumentService {
    NyistResult fileupload(MultipartFile file);
}
