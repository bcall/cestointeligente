package ar.com.itr.cestointeligente.controller;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/services")
public class FileController {

	private static Logger LOG = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "/download/{idUsuario}", method = RequestMethod.GET)
	public void download(@PathVariable("idUsuario") String idUsuario,  HttpServletResponse response) {
		try {
			String fullFileName = String.format("C:/Proyectos/cestointeligente/src/main/resources/imagen/codigoQR"+idUsuario+".png", idUsuario);
			FileInputStream stream = new FileInputStream(fullFileName);
			 IOUtils.copy(stream, response.getOutputStream());
		      response.flushBuffer();
		} catch (Exception ex) {
			LOG.info("Error writing file to output stream. Filename was '{}'", idUsuario, ex);
			throw new RuntimeException("IOError writing file to output stream");
		}

	}
}