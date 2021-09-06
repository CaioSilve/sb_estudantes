package silveira.caio.estudantes.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.estudantes.service.EstudanteService;

@Controller
@RequestMapping("/estudantes")
public class EstudantesController {

	@Autowired
	EstudanteService serv;
	
	@GetMapping
	public ModelAndView getAllEstudantes() {
		ModelAndView mv = new ModelAndView("ListaEstudantes");
		
		mv.addObject("estudantes", serv.getAllEstudantes());
		
		return mv;
		
	}
	
	
}
