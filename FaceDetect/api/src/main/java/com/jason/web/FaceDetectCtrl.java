package com.jason.web;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;

import com.jason.entity.FaceDetect;
import com.jason.entity.FaceInfo;
import com.jason.web.socket.handler.SystemWebSocketHandler;

@Controller
@RequestMapping("/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FaceDetectCtrl {
	
	@RequestMapping("/record/{requestStr}")
	public void test2(HttpServletRequest request,HttpServletResponse res
			,@PathVariable("requestStr") String requestStr) throws Exception{
		//获取数据包
		StringBuffer sb = new StringBuffer();
				BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
				String s = "";
				while(null != (s=reader.readLine())){
					sb.append(s);
				}
				String str=sb.toString();
		System.out.println(requestStr);
		System.out.println(str);
		PrintWriter pw = res.getWriter();
		pw.print("{\r\n" + 
				"    \"Result\": 0,\r\n" + 
				"    \"Content\": \"\",\r\n" + 
				"    \"Msg\": \"\"\r\n" + 
				"}");
	}
	
	//接收 人脸识别结果 
	@RequestMapping("/stranger")
	public void stranger(HttpServletRequest request,HttpServletResponse res
			,@RequestBody FaceDetect faceDetect) throws Exception{
		System.out.println(faceDetect.getSn());
		List<FaceInfo> faceInfos = faceDetect.getLogs();
		Iterator<FaceInfo> iter = faceInfos.iterator();
		String str = "";
		float confidence = 0.0F;
		while(iter.hasNext()) {
			FaceInfo temp = iter.next();
			str = temp.getPhoto();
			confidence = Float.valueOf(temp.getConfidence());
			System.out.println(str);
		}
		//jdk8的java.util.Base64;需执行下列操作，这里是版本问题
		str = str.replace("%0A", "");//去除换行
		str = str.substring(31);//去除前缀
		
		String isSuccess = "0";
		if(confidence > 60.0) {
			isSuccess = "1";
		}
		String photoName = String.valueOf(new Date().getTime());
		String baseStr = URLDecoder.decode(str,"utf-8");
		String ret = decryptByBase64(baseStr
				,"G:\\img\\photo\\" + isSuccess + "(" + confidence +")" + photoName + ".jpg");
		System.out.println(ret);
//		PrintWriter pw = res.getWriter();
//		pw.print("{\r\n" + 
//				"    \"Result\": 0,\r\n" + 
//				"    \"Content\": \"\",\r\n" + 
//				"    \"Msg\": \"更新成功\"\r\n" + 
//				"}");
	}
	
	//通过webSocket通道，向设备发送人员信息
	@RequestMapping("/sendUser")
	public void sendUser(HttpServletRequest request,HttpServletResponse res
			,@RequestParam("imgName") String imgName) throws Exception{
		File img = new File("G:\\img\\photo\\" + imgName + ".jpg");
		byte[] bytes = fileToByte(img);
		String base64Str = Base64.getEncoder().encodeToString(bytes);
		String preStr = "data:image/jpeg;base64,";
		String imgUrlCode = URLEncoder.encode(preStr + base64Str,"utf-8");
		String ret = "{" + 
				"\"cmd\":\"to_device\"," + 
				"\"form\":\"client_id\"," + 
				"\"to\":\"RLX-0110513\"," + 
				"\"data\":{\r\n" + 
				"\"cmd\":\"addUser\"," + 
				"\"user_id\":\"F1500001\"," + 
				"\"name\":\"test\"," + 
				"\"face_template\":\""+imgUrlCode+"\"," + 
				"\"effect_time\":\"\"," + 
				"\"id_valid\":\"2021-12-02 20:20\"," + 
				"\"valid_cycle\":[" + 
				"{" + 
				"\"start_time\":\"07:00\"," + 
				"\"end_time\":\"08:00\"" + 
				"}," + 
				"{" + 
				"\"start_time\":\"11:00\"," + 
				"\"end_time\":\"13:30\"" + 
				"}" + 
				"]" + 
				"}" + 
				"}";
		TextMessage txt = new TextMessage(ret);
        SystemWebSocketHandler.sendMessageToUsers(txt);	
		PrintWriter pw = res.getWriter();
		pw.print(ret);
	}
	
	  //byte数组到图片
	private void byte2image(byte[] data,String path){
      if(data.length<3||path.equals("")) return;
     try{
      FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
      imageOutput.write(data, 0, data.length);
      imageOutput.close();
      System.out.println("Make Picture success,Please find image in " + path);
      } catch(Exception ex) {
       System.out.println("Exception: " + ex);
       ex.printStackTrace();
     }
   }
	
	  private byte[] fileToByte(File img) throws Exception {
		  byte[] bytes = null;
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        try {
	            BufferedImage bi;
	            bi = ImageIO.read(img);
	            ImageIO.write(bi, "jpg", baos);
	            bytes = baos.toByteArray();
	            System.err.println(bytes.length);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            baos.close();
	        }
	        return bytes;
	    }
	
	 private String decryptByBase64(String base64, String filePath) throws Exception{
	        if (base64 == null && filePath == null) {
	            return "生成文件失败，请给出相应的数据。";
	        }
	        try {
	            Files.write(Paths.get(filePath),Base64.getDecoder().decode(base64), StandardOpenOption.CREATE);
	        } catch (IOException e) {
	            throw e;
	        }
	        return "指定路径下生成文件成功！";
	    }
	
}
