package crunchify.restjersey;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Student {

	private String firstname;
	private String lastname;
	private int age;
	private byte[] encodedByte;

	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
 
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] convertImage(String f) throws IOException {
	
		
		byte[] imageInByte;
		BufferedImage originalImage = ImageIO.read(new File(f));

		// convert BufferedImage to byte array
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();
		
		//convert byte array convert to base64

		byte[] encodedByte = Base64.getEncoder().encode(imageInByte);
		return encodedByte ;
		
}
		
		
	
	
		

	

	}
		

	

	
	
	

