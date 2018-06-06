package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by qilin.liu on 2018/4/16.
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){ //1
        try {
            FileUtils.writeByteArrayToFile(new File("e:/upload/"
                    +file.getOriginalFilename()),file.getBytes()); //2
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }
}
/*
    ①使用MultipartFile file接收上传的文件
    ②使用FileUtils.writeByteArrayToFile快速写文件到磁盘
 */
