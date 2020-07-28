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

import pe.com.minol.core.entities.Maquina;
import pe.com.minol.core.services.MinolService;

@Controller
public class MaquinaController {

	private final Logger logger = LoggerFactory.getLogger(MaquinaController.class);

	@Autowired
	private MinolService minolService;

	// list page
	@RequestMapping(value = "/maquina", method = RequestMethod.GET)
	public String showAllMaquina(Model model) {

		logger.debug("showAllMaquina()");
		model.addAttribute("maquina", minolService.findAllMaquina());
		return "maquina/list";

	}

	@RequestMapping(value = "/maquina/{id}", method = RequestMethod.GET)
	public String showMaquina(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		Maquina maquina = minolService.findMaquinaById(id);
		if (maquina == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("maquina", maquina);

		return "maquina/show";

	}

	@RequestMapping(value = "/maquina/{id}/update", method = RequestMethod.GET)
	public String showUpdateMaquinaForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		Maquina maquina = minolService.findMaquinaById(id);
		model.addAttribute("maquinaForm", maquina);

		// populateDefaultModel(model);

		return "maquina/maquinaform";

	}

	@RequestMapping(value = "/maquina", method = RequestMethod.POST)
	public String saveOrUpdateMaquina(@ModelAttribute("maquinaForm") @Validated Maquina maquina, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", maquina);

		if (result.hasErrors()) {
			// populateDefaultModel(model);
			return "users/maquinaform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (maquina.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Maquina added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Maquina updated successfully!");
			}

			maquina = minolService.saveOrUpdateMaquina(maquina);

			// POST/REDIRECT/GET
			return "redirect:/maquina/" + maquina.getIdMaquina();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@PostMapping("/maquina/add")
	public String addMaquina(Model model) {
		Maquina maquina = new Maquina();
		model.addAttribute("maquinaForm", maquina);
		return "maquina/maquinaform";
	}

}
