package com.smhrd.restController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QrRestController {
	
	@GetMapping("/qrA1")
    public ResponseEntity<byte[]> qrA1() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "A코스(순천대학교)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr1Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    
    @GetMapping("/qrA2")
    public ResponseEntity<byte[]> qrA2() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "A코스(순천대학교)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr2Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
   
    
    @GetMapping("/qrA3")
    public ResponseEntity<byte[]> qrA3() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "A코스(순천대학교)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr3Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    @GetMapping("/qrB1")
    public ResponseEntity<byte[]> qrB1() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "B코스(순천 조례호수공원)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr1Update?courseName="+ encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    @GetMapping("/qrB2")
    public ResponseEntity<byte[]> qrB2() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "B코스(순천 조례호수공원)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr2Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    @GetMapping("/qrB3")
    public ResponseEntity<byte[]> qrB3() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "B코스(순천 조례호수공원)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr3Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    @GetMapping("/qrC1")
    public ResponseEntity<byte[]> qrC1() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "C코스(순천 오천그린광장)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr1Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    
    @GetMapping("/qrC2")
    public ResponseEntity<byte[]> qrC2() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "C코스(순천 오천그린광장)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr2Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
    @GetMapping("/qrC3")
    public ResponseEntity<byte[]> qrC3() throws WriterException, IOException {
    	// QR 정보
        int width = 200;
        int height = 200;
        String original = "C코스(순천 오천그린광장)";
        String encoded = URLEncoder.encode(original, "UTF-8");
        String url = "http://172.30.1.59:8097/boot/qr3Update?courseName=" + encoded;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
        			.encode(url, BarcodeFormat.QR_CODE, width, height);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
	        //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){log.warn("QR Code OutputStream 도중 Excpetion 발생, {}", e.getMessage());}

        return null;
    }
    
}

