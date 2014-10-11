package Favoris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavorisController {

	@Autowired
	private FavorisRepository FavorisRepository;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("favoris", new Favoris());
		return "create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute Favoris favoris, Model model) {
		
		FavorisRepository.save(favoris);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listProducts(Model model) {
		
		model.addAttribute("favoris", FavorisRepository.findAll());
		return "list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") Long id, Model model) {
		
		FavorisRepository.delete(id);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editForm(@RequestParam("id") Long id, Model model) {
		
		model.addAttribute("favoris", FavorisRepository.findOne(id));
		return "create";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPost(@ModelAttribute Favoris favoris, Model model) {
		FavorisRepository.save(favoris);
		return "redirect:/";
	}

	

}