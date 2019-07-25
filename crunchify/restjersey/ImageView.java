package crunchify.restjersey;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * File f = new File(getServletContext().getRealPath("") + File.separator +
		 * "ASTRO2.BMP");
		 */

		File f = new File("C:\\Users\\user\\Desktop\\ASTRO2.BMP");

		FileInputStream fin = new FileInputStream(f);
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("image/BMP");
		int i = 0;
		while (i != -1) {
			i = fin.read();
			outStream.write(i);
		}
		fin.close();

		// http://localhost:8080/ImageProject/ImageView

	}
}
