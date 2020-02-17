package com.springboot.weekly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Controller
public class FileController {
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestParam("filename") String filename) {
        try {
            // 文件地址，真实环境是存放在数据库中的
            File file = new File(filename);
            // 创建输入流，传入文件对象
            FileInputStream fis = new FileInputStream(file);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            response.addHeader("Content-disposition", "attachment;filename=" + filename);
            OutputStream os = response.getOutputStream();
            // 常规操作
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            os.close();
            fis.close();
                   //为了测试方便  我写了两个html  一个是success.html还有一个是error.html  用来表示成功还是失败
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}