package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")

public class RecoveryRoomController {

	private static final String VIEWS_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

	private RecoveryRoomService recoveryRoomService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}

	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		modelMap.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
		modelMap.addAttribute("recoveryRoom", new RecoveryRoom());

		return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(path = "/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap modelMap) {
		String vista = "welcome";
		if (result.hasErrors()) {
			modelMap.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
			modelMap.addAttribute("recoveryRoom", new RecoveryRoom());
			return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
		} else {
			recoveryRoomService.save(recoveryRoom);
			modelMap.addAttribute("message", "Product succesfullu saved");
			return vista;
		}

	}

}
