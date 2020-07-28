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

import pe.com.minol.core.entities.Repuesto;
import pe.com.minol.core.services.MinolService;

@Controller
public class RepuestoController {

	private final Logger logger = LoggerFactory.getLogger(RepuestoController.class);

	@Autowired
	private MinolService minolService;

	// list page
	@RequestMapping(value = "/repuesto", method = RequestMethod.GET)
	public String showAllRepuesto(Model model) {

		logger.debug("showAllRepuesto()");
		model.addAttribute("repuesto", minolService.findAllRepuesto());
		return "repuesto/list";

	}

	@RequestMapping(value = "/repuesto/{id}", method = RequestMethod.GET)
	public String showRepuesto(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		Repuesto repuesto = minolService.findRepuestoById(id);
		if (repuesto == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("repuesto", repuesto);

		return "repuesto/show";

	}

	@RequestMapping(value = "/repuesto/{id}/update", method = RequestMethod.GET)
	public String showUpdateRepuestoForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		Repuesto repuesto = minolService.findRepuestoById(id);
		model.addAttribute("repuestoForm", repuesto);

		// populateDefaultModel(model);

		return "repuesto/repuestoform";

	}

	@RequestMapping(value = "/repuesto", method = RequestMethod.POST)
	public String saveOrUpdateRepuesto(@ModelAttribute("repuestoForm") @Validated Repuesto repuesto, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", repuesto);

		if (result.hasErrors()) {
			// populateDefaultModel(model);
			return "users/repuestoform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (repuesto.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Repuesto added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Repuesto updated successfully!");
			}

			repuesto = minolService.saveOrUpdateRepuesto(repuesto);

			// POST/REDIRECT/GET
			return "redirect:/repuesto/" + repuesto.getIdrepuesto();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@PostMapping("/repuesto/add")
	public String addRepuesto(Model model) {
		Repuesto repuesto = new Repuesto();
		model.addAttribute("repuestoForm", repuesto);
		return "repuesto/repuestoform";
	}

}
