package kr.co.acomp.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/bbs")
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("name") String filename,
                         Model model) throws IllegalStateException, IOException {

        if (!file.isEmpty()){ // 파일이 있다면
            // 해당 경로에 원본 파일 명 갖고와서 저장
            File f = new File("/Users/minwoo/Desktop/code/demo/upload", file.getOriginalFilename());
            file.transferTo(f);
        }
        model.addAttribute("fileName",filename);
        return "upload_ok";

    }
}
