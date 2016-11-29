package es.salesianos.model.assembler;
import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;

import es.salesianos.model.Idiomas;
public class IdiomaAssembler {
	public static Idiomas assembleIdiomaFrom(HttpServletRequest req) {
		Idiomas idiomas = new Idiomas();
		String Idioma = req.getParameter("idioma");
		
		if (!StringUtils.isNullOrEmpty(Idioma))
			idiomas.setIdioma(Idioma);
		
		return idiomas;
	}	

}
