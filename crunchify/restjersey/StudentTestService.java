package crunchify.restjersey;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/studentservice")
public class StudentTestService {

	public StudentTestService() {
		imageclass = new ImageView();
	}

	private ImageView imageclass;
	private static Student obj;

	@GET
	// @Produces("application/xml")
	@Path("/testservice")
	public Response getStudentDetails() throws IOException {

		Student st = new Student();
		st.setFirstName("ilayda");
		st.setLastName("Turk");
		st.setAge(21);
		byte[] encodedByte = st.convertImage("C:\\Desktop\\Images\\Joker_0026.jpg");

		byte[] decodedByte = Base64.getDecoder().decode(encodedByte);
		InputStream in = new ByteArrayInputStream(decodedByte);
		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File("C:\\Desktop\\Images\\Base64ConvertJoker.jpg"));
		return Response.status(200)
				.entity(st.getFirstName() + " " + st.getLastName() + " " + st.getAge() + " " + encodedByte + imageclass)
				.build();

	}

	// http://localhost:8080/ImageProject/crunchify/studentservice/testservice

	@GET
	// @Produces("application/xml")
	@Path("/displayservice")
	public Response DisplayStudentDetails(@Context UriInfo info) throws IOException {
		String firstname = info.getQueryParameters().getFirst("firstname");
		String lastname = info.getQueryParameters().getFirst("lastname");
		String age = info.getQueryParameters().getFirst("age");
		String file = info.getQueryParameters().getFirst("file");
		obj = new Student();
		obj.setFirstName(firstname);
		obj.setLastName(lastname);
		obj.setAge(Integer.valueOf(age));
		// byte[] encodedByte=obj.convertImage(file);
		return Response.status(200).entity(
				"firstname: " + obj.getFirstName() + "lastname:  " + obj.getLastName() + " age: " + obj.getAge())
				.build();
	}
	// http://localhost:8080/ImageProject/crunchify/studentservice/displayservice?firstname=ilayda&lastname=turk&age=21

}
