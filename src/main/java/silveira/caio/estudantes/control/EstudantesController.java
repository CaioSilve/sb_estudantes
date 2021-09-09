package silveira.caio.estudantes.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.estudantes.entity.Estudante;
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
		
		if(serv.getAllEstudantes().isEmpty()) {
			mv.setStatus(HttpStatus.BAD_REQUEST);
		} else {
			mv.setStatus(HttpStatus.OK);
		}
		
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView setEstuForm() {
		ModelAndView mv = new ModelAndView("NovoEstudante");
		Estudante es = new Estudante();
		
		mv.addObject("estu", es);
		mv.setStatus(HttpStatus.OK);
		
		return mv;	
	}
	
	
	@PostMapping
	public ModelAndView saveEstudante(@ModelAttribute("estu") Estudante estu) {
		ModelAndView mv = new ModelAndView("Estudantes");
		
		serv.saveEstudante(estu);
		mv.setStatus(HttpStatus.OK);
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
}
