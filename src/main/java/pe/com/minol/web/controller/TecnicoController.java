package pe.com.minol.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.minol.core.entities.Tecnico;
import pe.com.minol.core.services.MinolService;

@Controller
public class TecnicoController {

	private final Logger logger = LoggerFactory.getLogger(TecnicoController.class);

	@Autowired
	private MinolService minolService;

	// list page
	@RequestMapping(value = "/tecnico", method = RequestMethod.GET)
	public String showAllTecnico(Model model) {

		logger.debug("showAllTecnico()");
		model.addAttribute("tecnico", minolService.findAllTecnico());
		return "tecnico/list";

	}

	@RequestMapping(value = "/tecnico/{id}", method = RequestMethod.GET)
	public String showTecnico(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		Tecnico tecnico = minolService.findTecnicoById(id);
		if (tecnico == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("tecnico", tecnico);

		return "tecnico/show";

	}

	@RequestMapping(value = "/tecnico/{id}/update", method = RequestMethod.GET)
	public String showUpdateTecnicoForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		Tecnico tecnico = minolService.findTecnicoById(id);
		model.addAttribute("tecnicoForm", tecnico);

		// populateDefaultModel(model);

		return "tecnico/tecnicoform";

	}

	@RequestMapping(value = "/tecnico", method = RequestMethod.POST)
	public String saveOrUpdateTecnico(@ModelAttribute("tecnicoForm") @Validated Tecnico tecnico, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", tecnico);

		if (result.hasErrors()) {
			// populateDefaultModel(model);
			return "users/tecnicoform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (tecnico.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Tecnico added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Tecnico updated successfully!");
			}

			tecnico = minolService.saveOrUpdateTecnico(tecnico);

			// POST/REDIRECT/GET
			return "redirect:/tecnico/" + tecnico.getIdtecnico();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@PostMapping("/tecnico/add")
	public String addTecnico(Model model) {
		Tecnico tecnico = new Tecnico();
		model.addAttribute("tecnicoForm", tecnico);
		return "tecnico/tecnicoform";
	}

}
