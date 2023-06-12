package com.zzh.data.analysis.controller;

import com.alibaba.excel.EasyExcel;
import com.zzh.data.analysis.entity.Product;
import com.zzh.data.analysis.listener.PriceInfoListener;
import com.zzh.data.analysis.entity.PriceInfo;
import com.zzh.data.analysis.listener.SKUListener;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: zzh
 * @description: excel 接口
 */
@RestController
@RequestMapping("/")
@Slf4j
public class ExcelController {

    @Value("${community.path.excel}")
    private String filePath;

    /**
     * 分割 excel
     * @param excel excel 文件
     * @param column 标准
     */
    @PostMapping("splitExcel")
    public void splitExcel(MultipartFile excel, HttpServletResponse response, String column) throws IOException {
        String fileName = System.currentTimeMillis() + column;
        String folder = filePath + fileName;
        File dir = new File(folder);
        boolean flag = dir.mkdirs();
        log.info("创建文件夹 ==> {}", flag);

        EasyExcel.read(excel.getInputStream(), PriceInfo.class, new PriceInfoListener(column, folder)).sheet().doRead();
        
        // 压缩文件
        String zipPath = folder + ".zip"; 
        FileOutputStream fos = new FileOutputStream(zipPath);
        ZipOutputStream zos = new ZipOutputStream(fos);
        compressFolder(dir, fileName, zos);
        
        // 返回 zip 文件
        responseFile(response, zipPath);
    }

    private void responseFile(HttpServletResponse response, String zipPath) {
        File file = new File(zipPath);

        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            if(file.exists()) {
                response.addHeader("Content-Disposition", "attachment; filename=" +
                        URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
                response.setContentType("application/octet-stream;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                os = response.getOutputStream();
                bis = new BufferedInputStream(Files.newInputStream(file.toPath()));
                while(bis.read(buffer) != -1){
                    os.write(buffer);
                }
            } else {
                log.error("文件未找到 ==> {}", file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null) {
                    bis.close();
                }
                if(os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @PostMapping("sukSplit")
    public void skuSplit(MultipartFile excel, HttpServletResponse response) throws IOException {
        EasyExcel.read(excel.getInputStream(), Product.class, new SKUListener(filePath)).sheet().doRead();
        String fileName = filePath + "\\" +  "sku.xlsx";
        responseFile(response, fileName);
    }

    private static void compressFolder(File folder, String zipName, ZipOutputStream zos) throws IOException {
        String name = folder.getName();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                compressFolder(file, name + "/" + file.getName(), zos);
            } else {
                byte[] buffer = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(zipName + "/" + file.getName()));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
        }
    }
    
}
