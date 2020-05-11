package com.example.demo.controller;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class FileController {

    private  static String fileName2 = null;
    public  void cutslide(){

        String path = "C:\\Users\\hp\\Desktop\\image\\"+fileName2;
        try {
            String[] args1 = new String[] { "python", "C:\\Users\\hp\\Desktop\\PPTtoPicture\\venv\\transPPT.py", path };
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getFile(String filepath) {
        int count=0;
        File file = new File(filepath);
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            if (!listfile[i].isDirectory()) {
                String temp=listfile[i].toString().substring(7,listfile[i].toString().length()) ;
                count++;
            } else {
                getFile(listfile[i].toString());
            }

        }
        return count;
    }

    @RequestMapping("/getfile/number")
    public int getFilenumber(){
        String[] str = fileName2.split("\\.");
        System.out.println("getFileNumber:::::::::::::::::::::::::::::::::::");
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
        System.out.println("end__________________________________________-");
        System.out.println(str);
        String tempname = str[0];
        return getFile("C:\\Users\\hp\\Desktop\\PPTtoPicture\\venv\\"+tempname+"\\output");
    }

    //实现Spring Boot 的文件下载功能，映射网址为/download
    @RequestMapping("/download/{number}")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response, @PathVariable("number") int number) throws UnsupportedEncodingException {

        // 获取指定目录下的第一个文件
        String[] str = fileName2.split("\\.");
        String tempname = str[0];
        File scFileDir = new File("C:\\Users\\hp\\Desktop\\PPTtoPicture\\venv\\"+tempname+"\\output");
        File TrxFiles[] = scFileDir.listFiles();
        System.out.println(TrxFiles[number]);
        String fileName = TrxFiles[number].getName(); //下载的文件名
        String temp[] = fileName2.split(",");
        String filestr = temp[0];

        String absolu = "C:\\Users\\hp\\Desktop\\PPTtoPicture\\venv\\"+tempname+"\\output\\"+fileName;
        absolu = URLDecoder.decode(absolu, "UTF-8");
        return GetImageStr(absolu);
    }

    public static String GetImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
       // String imgFile = "/Users/rico-yang/Documents/file/p1.jpg";// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        System.out.println("________________imgfile");
        System.out.println(imgFile);
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }

    @RequestMapping("/multiUpload")
    @ResponseBody
    public String multiUpload(HttpServletRequest request) {


        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        System.out.println("11111111111111111");
        String filePath = "C:\\Users\\hp\\Desktop\\image\\"+fileName2;
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCc");
        System.out.println(filePath);
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath);
            try {
                file.transferTo(dest);
                cutslide();
                //LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
               // LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";

    }

    @RequestMapping("/stu/router")
    public String router(@RequestBody String json){
        JSONObject file = JSONObject.parseObject(json);

        fileName2 = file.getString("fileName");
        System.out.println(fileName2);
        return file.getString("fileName");
    }






}
