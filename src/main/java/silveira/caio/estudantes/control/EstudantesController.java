package silveira.caio.estudantes.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		ModelAndView mv = new ModelAndView("redirect:/estudantes");
		
		mv.setStatus(HttpStatus.OK);
		try {
			serv.saveEstudante(estu);
		} catch (Exception e) {
			mv.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editEstudanteForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("EditarEstudante");
		
		mv.setStatus(HttpStatus.OK);
		mv.addObject("estu", serv.getEstudanteById(id));
		
		if(serv.getEstudanteById(id) == null) mv.setStatus(HttpStatus.BAD_REQUEST);
		
		
		return mv;
	}
	
	@PostMapping("/{id}")
	public ModelAndView updateEstudante(@PathVariable Long id, @ModelAttribute("estu") Estudante estu) {
		ModelAndView mv = new ModelAndView("redirect:/estudantes");
		
		Estudante old = serv.getEstudanteById(id);
		old.setNome(estu.getNome());
		old.setEnde(estu.getEnde());
		old.setEmail(estu.getEmail());
		old.setFone(estu.getFone());
		
		serv.updateEstudante(old);
		
		return mv;
	}
	
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deleteEstudante(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("redirect:/estudantes");
		
		mv.setStatus(HttpStatus.OK);
		
		serv.deleteEstudanteById(id);
		
		
		return mv;
	}
	
	
	
}
	
	
	
	
	
	
	
	

