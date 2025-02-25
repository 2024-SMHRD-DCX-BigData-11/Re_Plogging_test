package com.smhrd.restController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.smhrd.entity.CommonDomain;
import com.smhrd.entity.Member;
import com.smhrd.entity.Sms;
import com.smhrd.repository.MemberRepository;
import com.smhrd.repository.SmsRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Payload;

@RestController
@RequestMapping("/rest/sms/")
public class SendRestController {
	
	@Autowired
	private MemberRepository repo; // 멤버 레파지토리를 사용하기 위한 변수 선언
	
	@Autowired
	private SmsRepository srepo; // SmsCheckRepository를 사용하기 위한 변수 선언

	/**
	 * ============================================================== Description :
	 * 사용 함수 선언 ==============================================================
	 **/
	/**
	 * nullcheck
	 * 
	 * @param str, Defaultvalue
	 * @return
	 */

	public static String nullcheck(String str, String Defaultvalue) throws Exception {
		String ReturnDefault = "";
		if (str == null) {
			ReturnDefault = Defaultvalue;
		} else if (str == "") {
			ReturnDefault = Defaultvalue;
		} else {
			ReturnDefault = str;
		}
		return ReturnDefault;
	}

	/**
	 * BASE64 Encoder
	 * 
	 * @param str
	 * @return
	 */
	public static String base64Encode(String str) throws java.io.IOException {
		String result = Base64.getEncoder().encodeToString(str.getBytes());
		return result;
	}

	/**
	 * BASE64 Decoder
	 * 
	 * @param str
	 * @return
	 */
	public static String base64Decode(String str) throws java.io.IOException {
		byte[] decodedBytes = Base64.getDecoder().decode(str);
		return new String(decodedBytes);
	}

	@RequestMapping("/shipping12")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("시작");
		try {
			String charsetType = "EUC-KR"; // EUC-KR 또는 UTF-8

			request.setCharacterEncoding(charsetType);
			response.setCharacterEncoding(charsetType);
			String action = nullcheck(request.getParameter("action"), "");
			if (action.equals("go")) {

				String sms_url = "https://sslsms.cafe24.com/sms_sender.php"; // SMS 전송요청 URL
				String user_id = base64Encode("iworks2018"); // SMS아이디
				String secure = base64Encode("ac48f9ab4e7200e10b27c5b7b5fc633b");// 인증키
				String msg = base64Encode(nullcheck(request.getParameter("msg"), ""));
				String rphone = base64Encode(nullcheck(request.getParameter("rphone"), ""));
//				String sphone1 = base64Encode(nullcheck(request.getParameter("sphone1"), ""));
//				String sphone2 = base64Encode(nullcheck(request.getParameter("sphone2"), ""));
//				String sphone3 = base64Encode(nullcheck(request.getParameter("sphone3"), ""));
				String sphone1 = base64Encode(nullcheck("061-746-0030", ""));
				String sphone2 = base64Encode(nullcheck("061-746-0030", ""));
				String sphone3 = base64Encode(nullcheck("061-746-0030", ""));
				String rdate = base64Encode(nullcheck(request.getParameter("rdate"), ""));
				String rtime = base64Encode(nullcheck(request.getParameter("rtime"), ""));
				String mode = base64Encode("1");
				String subject = "";
				if (nullcheck(request.getParameter("smsType"), "").equals("L")) {
					subject = base64Encode(nullcheck(request.getParameter("subject"), ""));
				}
				String testflag = base64Encode(nullcheck(request.getParameter("testflag"), ""));
				String destination = base64Encode(nullcheck(request.getParameter("destination"), ""));
				String repeatFlag = base64Encode(nullcheck(request.getParameter("repeatFlag"), ""));
				String repeatNum = base64Encode(nullcheck(request.getParameter("repeatNum"), ""));
				String repeatTime = base64Encode(nullcheck(request.getParameter("repeatTime"), ""));
				String returnurl = nullcheck(request.getParameter("returnurl"), "");
				String nointeractive = nullcheck(request.getParameter("nointeractive"), "");
				String smsType = base64Encode(nullcheck(request.getParameter("smsType"), ""));

				String[] host_info = sms_url.split("/");
				String host = host_info[2];
				String path = "/" + host_info[3];
				int port = 80;

				// 데이터 맵핑 변수 정의
//				String arrKey[] = new String[] { "user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3",
//						"rdate", "rtime", "mode", "testflag", "destination", "repeatFlag", "repeatNum", "repeatTime",
//						"smsType", "subject" };
//				String valKey[] = new String[arrKey.length];
//				valKey[0] = user_id;
//				valKey[1] = secure;
//				valKey[2] = msg;
//				valKey[3] = rphone;
//				valKey[4] = sphone1;
//				valKey[5] = sphone2;
//				valKey[6] = sphone3;
//				valKey[7] = rdate;
//				valKey[8] = rtime;
//				valKey[9] = mode;
//				valKey[10] = testflag;
//				valKey[11] = destination;
//				valKey[12] = repeatFlag;
//				valKey[13] = repeatNum;
//				valKey[14] = repeatTime;
//				valKey[15] = smsType;
//				valKey[16] = subject;
				String arrKey[] = new String[] { "user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3",
						"mode", "smsType" };
				String valKey[] = new String[arrKey.length];
				valKey[0] = user_id;
				valKey[1] = secure;
				valKey[2] = msg;
				valKey[3] = rphone;
				valKey[4] = sphone1;
				valKey[5] = sphone2;
				valKey[6] = sphone3;
				valKey[7] = mode;
				valKey[8] = smsType;

				String boundary = "";
				Random rnd = new Random();
				String rndKey = Integer.toString(rnd.nextInt(32000));
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] bytData = rndKey.getBytes();
				md.update(bytData);
				byte[] digest = md.digest();
				for (int i = 0; i < digest.length; i++) {
					boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
				}
				boundary = "---------------------" + boundary.substring(0, 11);

				// 본문 생성
				String data = "";
				String index = "";
				String value = "";
				for (int i = 0; i < arrKey.length; i++) {
					index = arrKey[i];
					value = valKey[i];
					data += "--" + boundary + "\r\n";
					data += "Content-Disposition: form-data; name=\"" + index + "\"\r\n";
					data += "\r\n" + value + "\r\n";
					data += "--" + boundary + "\r\n";
				}

				System.out.println("data : " + data);

				// out.println(data);

//				InetAddress addr = InetAddress.getByName(host);
				Socket socket = new Socket(host, port);
				// 헤더 전송
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
				wr.write("POST " + path + " HTTP/1.0\r\n");
				wr.write("Content-Length: " + data.length() + "\r\n");
				wr.write("Content-type: multipart/form-data, boundary=" + boundary + "\r\n");
				wr.write("\r\n");

				// 데이터 전송
				wr.write(data);
				wr.flush();

				// 결과값 얻기
				BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(), charsetType));
				String line;
				String alert = "";
				ArrayList<String> tmpArr = new ArrayList<>();
				while ((line = rd.readLine()) != null) {
					tmpArr.add(line);
				}
				wr.close();
				rd.close();

				String tmpMsg = (String) tmpArr.get(tmpArr.size() - 1);
				String[] rMsg = tmpMsg.split(",");
				String Result = rMsg[0]; // 발송결과
				String Count = ""; // 잔여건수
				if (rMsg.length > 1) {
					Count = rMsg[1];
				}

				// 발송결과 알림
				if (Result.equals("success")) {
					alert = "성공적으로 발송하였습니다.";
					alert += " 잔여건수는 " + Count + "건 입니다.";
				} else if (Result.equals("reserved")) {
					alert = "성공적으로 예약되었습니다";
					alert += " 잔여건수는 " + Count + "건 입니다.";
				} else if (Result.equals("3205")) {
					alert = "잘못된 번호형식입니다.";
				} else {
					alert = "[Error]" + Result;
				}

				socket.close();

				System.out.println(nointeractive);

//			out.println(nointeractive);
//
				if (nointeractive.equals("1") && !(Result.equals("Test Success!")) && !(Result.equals("success"))
						&& !(Result.equals("reserved"))) {
					System.out.println("몰라1");
					System.out.println(alert);
//				out.println("<script>alert('" + alert + "')</script>");
				} else if (!(nointeractive.equals("1"))) {
					System.out.println("몰라2");
//				out.println("<script>alert('" + alert + "')</script>");
				}
//
//			out.println("<script>location.href='" + returnurl + "';</script>");
				System.out.println(returnurl);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "test";
	}
	

	@RequestMapping(value = "/shipping1234", method = RequestMethod.POST)
	public CommonDomain savesms(
			MultipartHttpServletRequest request
			) {
		
		CommonDomain response = new CommonDomain();
		
		int code = (int)(Math.random() * 900000 + 100000);
		String smsPhone = request.getParameter("phoneNumber").toString();
		Sms sms = new Sms();
		sms.setSmsCode(code);
		sms.setSmsPhone( smsPhone );
		
		// sms check 조회 with smsPhone
		int resultCode = 0;
		Sms sms2 = srepo.findByPhoneNumber(smsPhone);
		if (sms2 != null) {
			sms2.setSmsCode(code);
			srepo.save( sms2 );
		} else {
			srepo.save( sms );
		}
		
		
//		resultCode = srepo.save( sms );
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("smsPhone", smsPhone );
		resultMap.put("smsCode", code );
		
		if( resultCode != 1 ) {
			CommonDomain sendResult = sendsms( smsPhone, code );
			response.setCode( sendResult.getCode()); 		
		} else {
			response.setCode(-200);
		}
		
		
		
		return response;
	}
	
	private CommonDomain sendsms(
			@RequestParam( value= "phoneNumber") String phoneNumber,
			@RequestParam( value= "code") int code
			) {
		CommonDomain response = new CommonDomain();
		
		
		try { 
			String sms_url = "";
			sms_url = "https://sslsms.cafe24.com/sms_sender.php"; // SMS 전송요청 URL
			String user_id = base64Encode("iworks2018"); // SMS아이디
			String secure = base64Encode("ac48f9ab4e7200e10b27c5b7b5fc633b");// 인증키
			String msg = base64Encode(nullcheck("Re:plogging 인증번호는 [" + code + "] 입니다.", ""));
			String rphone = base64Encode(nullcheck(phoneNumber, ""));
			String sphone1 = base64Encode(nullcheck("061", "")); // cafe24에 등록된 폰번호 010
			String sphone2 = base64Encode(nullcheck("746", "")); // cafe24에 등록된 폰번호 1111
			String sphone3 = base64Encode(nullcheck("0030", ""));// cafe24에 등록된 폰번호 1111
			String mode = base64Encode("1");
			String smsType = base64Encode(nullcheck("5", ""));
			String[] host_info = sms_url.split("/");
			String host = host_info[2];
			String path = "/" + host_info[3];
			int port = 80;
			// 데이터 맵핑 변수 정의

			String charsetType = "UTF-8";

			String arrKey[] = new String[] { "user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3",
					"mode", "smsType" };
			String valKey[] = new String[arrKey.length];
			valKey[0] = user_id;
			valKey[1] = secure;
			valKey[2] = msg;
			valKey[3] = rphone;
			valKey[4] = sphone1;
			valKey[5] = sphone2;
			valKey[6] = sphone3;
			valKey[7] = mode;
			valKey[8] = smsType;

			String boundary = "";
			Random rnd = new Random();
			String rndKey = Integer.toString(rnd.nextInt(32000));
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytData = rndKey.getBytes();
			md.update(bytData);
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; i++) {
				boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
			}
			boundary = "---------------------" + boundary.substring(0, 11);
			// 본문 생성
			String data = "";
			String index = "";
			String value = "";

			for (int i = 0; i < arrKey.length; i++) {
				index = arrKey[i];
				value = valKey[i];
				data += "--" + boundary + "\r\n";
				data += "Content-Disposition: form-data; name=\"" + index + "\"\r\n";
				data += "\r\n" + value + "\r\n";
				data += "--" + boundary + "\r\n";
			}
			// out.println(data);
			Socket socket = new Socket(host, port);
			// 헤더 전송
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
			wr.write("POST " + path + " HTTP/1.0\r\n");
			wr.write("Content-Length: " + data.length() + "\r\n");
			wr.write("Content-type: multipart/form-data, boundary=" + boundary + "\r\n");
			wr.write("\r\n");
			// 데이터 전송
			wr.write(data);
			wr.flush();
			// 결과값 얻기
			BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(), charsetType));
			String line;
			String alert = "";
			ArrayList tmpArr = new ArrayList();
			while ((line = rd.readLine()) != null) {
				tmpArr.add(line);
			}
			wr.close();
			rd.close();

			String tmpMsg = (String) tmpArr.get(tmpArr.size() - 1);
			String[] rMsg = tmpMsg.split(",");
			String Result = rMsg[0]; // 발송결과
			String Count = ""; // 잔여건수
			if (rMsg.length > 1) {
				Count = rMsg[1];
			}

			// 발송결과 알림
			if (Result.equals("success")) {
				alert = "성공적으로 발송하였습니다.";
				alert += " 잔여건수는 " + Count + "건 입니다.";
			} else if (Result.equals("reserved")) {
				alert = "성공적으로 예약되었습니다";
				alert += " 잔여건수는 " + Count + "건 입니다.";
			} else if (Result.equals("3205")) {
				alert = "잘못된 번호형식입니다.";
			} else {
				alert = "[Error]" + Result;
			}

			System.out.println(data);
			System.out.println(alert);
			
			response.setCode(200);
		} catch (Exception ex) {
			 ex.printStackTrace();
			 response.setCode(-100);
		}
		return response;
	}
}
