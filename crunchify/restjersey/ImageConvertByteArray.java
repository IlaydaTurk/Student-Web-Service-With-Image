package crunchify.restjersey;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;



public class ImageConvertByteArray {
	public static void main(String[] args) throws IOException {

		ConvertImage();
		
	}
	public static void ConvertImage() throws IOException {
		byte[] imageInByte;
		BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Joker_0026.jpg"));

		// convert BufferedImage to byte array
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();
		
		//convert byte array convert to base64

		byte[] encodedByte = Base64.getEncoder().encode(imageInByte);
		byte[] decodedByte = Base64.getDecoder().decode(encodedByte);

		System.out.println(encodedByte);

		/*
		 * BitmapFactory options = new BitmapFactory();
		 * 
		 * Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByte, 0,
		 * decodedByte.length); System.out.println(bitmap);
		 */
		
		
		// convert byte array back to BufferedImage
		
			      ByteArrayInputStream bis = new ByteArrayInputStream(imageInByte);
			      BufferedImage bImage2 = ImageIO.read(bis);
			      ImageIO.write(bImage2, "jpg", new File("C:\\Users\\user\\Desktop\\NEWJoker_0026.jpg") );
			     
			   
			
		

		//convert base64 string to BufferedImage

		InputStream in = new ByteArrayInputStream(decodedByte);
		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File("C:\\Users\\user\\Desktop\\new-darksouls.jpg"));
	}
	}


