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

import pe.com.minol.core.entities.Client;
import pe.com.minol.core.services.MinolService;

@Controller
public class ClientController {

	private final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private MinolService minolService;

	// list page
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String showAllClients(Model model) {

		logger.debug("showAllClients()");
		model.addAttribute("clients", minolService.findAllClients());
		return "clients/list";

	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public String showClient(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		Client client = minolService.findClientById(id);
		if (client == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("client", client);

		return "clients/show";

	}

	@RequestMapping(value = "/clients/{id}/update", method = RequestMethod.GET)
	public String showUpdateClientForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		Client client = minolService.findClientById(id);
		model.addAttribute("clientForm", client);

		// populateDefaultModel(model);

		return "clients/clientform";

	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public String saveOrUpdateClient(@ModelAttribute("clientForm") @Validated Client client, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", client);

		if (result.hasErrors()) {
			// populateDefaultModel(model);
			return "clients/clientform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (client.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			client = minolService.saveOrUpdateClient(client);

			// POST/REDIRECT/GET
			return "redirect:/clients/" + client.getClientId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@PostMapping("/clients/add")
	public String addClient(Model model) {
		Client client = new Client();
		model.addAttribute("clientForm", client);
		return "clients/clientform";
	}

}
