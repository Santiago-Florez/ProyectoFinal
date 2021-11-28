package co.edu.unbosque.servlet;

import co.edu.unbosque.servlet.dto.Imagenes;
import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "img-servlet", value = "/img-servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class guardarImg extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "imgsPets";
    private String fileName = "";
    private Imagenes imgs;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            for (Part part : request.getParts()) {
                fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);

            }
            ArrayList<Imagenes> dataImg = new ArrayList<>();
            imgs = new Imagenes(fileName);
            dataImg.add(imgs);
            response.sendRedirect(request.getContextPath() + "/owner.html");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
