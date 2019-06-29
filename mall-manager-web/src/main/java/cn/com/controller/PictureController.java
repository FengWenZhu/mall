package cn.com.controller;

import cn.com.utils.FastDFSClient;
import cn.com.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "图片上传")
@RestController
@RequestMapping("/pic")
public class PictureController {
    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @ApiOperation(value = "图片上传")
    @RequestMapping(value = "/upload" , produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String fileUplod(MultipartFile uploadFile){
        try {
            //取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //创建一个FastDFS的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/fastdfs-client.conf");
            String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //拼接返回的url和ip地址，拼装成完整的url
            String url = IMAGE_SERVER_URL + path;
            Map result = new HashMap<>();
            result.put("error",0);
            result.put("url",url);
            return JsonUtils.objectToJson(result);
        }catch(Exception e){
            Map result = new HashMap<>();
            result.put("error",0);
            result.put("message","图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}
