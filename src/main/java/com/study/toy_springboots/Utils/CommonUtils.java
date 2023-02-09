package com.study.toy_springboots.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class CommonUtils {

    public String makeUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Map FileUpload(MultipartHttpServletRequest multipartHttpServletRequest) {
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        String relativePath = "C:\\Develops\\toy_springboots\\src\\main\\resources\\static\\files\\";
        String physicalFileName = this.makeUuid();
        String saveFilePath = relativePath+physicalFileName+"\\";
        Map map = new HashMap<>();

        String originalFileName = "";
        File newfile = new File(saveFilePath);
        newfile.mkdir();
        while(fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            originalFileName = multipartFile.getOriginalFilename();
            String filePath = saveFilePath+originalFileName;
            try {
                multipartFile.transferTo(new File(filePath));

            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("originalFileName", originalFileName);
        map.put("physicalFileName", physicalFileName);
        return map;
    }
}
