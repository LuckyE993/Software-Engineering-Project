package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class fileUploadController {
    @PostMapping("/upload")
    public String upload(String nickname , MultipartFile photo, HttpServletRequest request) throws IOException {

        System.out.println("nickname = " + nickname);
        System.out.println("photo = " + photo.getOriginalFilename());
        System.out.println("request = " + request);

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("path = " + path);
        saveFile(photo,path);

        return "Upload ok";

    }

    private void saveFile(MultipartFile photo, String path) {
        File dir = new File(path); // File
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            File file = new File(path+photo.getOriginalFilename());
            photo.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
