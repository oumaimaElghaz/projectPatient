package ma.emsi.tp_jpa.web;

import java.util.List;



import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import lombok.val;
import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@Controller
public class patientController {
	@Autowired
	private PatientRepository patientRepository;
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	@GetMapping(path = "/patients")
	public String liste(Model model, @RequestParam(name="page", defaultValue="0") int page,
			 @RequestParam(name="size", defaultValue="5") int size,
			 @RequestParam(name="keyword", defaultValue="") String mc) {
		Page<Patient> pagePatients = patientRepository.findByNomContains(mc, PageRequest.of(page, size));
		model.addAttribute("patients",pagePatients.getContent());
		model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("keyword",mc);
		
		return "patient";
	}
	@GetMapping(path="/deletePatient")
	public String delete(Long id, String keyword, int page, int size, Model model) {
		patientRepository.deleteById(id);
		return liste(model, page, size , keyword);
		
	}
	@GetMapping(path="/editerPatient")
	public String editPatient(Model model, Long id) {
		Patient patient=patientRepository.findById(id).get();
		model.addAttribute("patient", patient);
		model.addAttribute("mode", "edit");
	return "formPatient";
	}
	@GetMapping(path="/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient",new Patient());
		model.addAttribute("model", "new");
		return "formPatient";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(Model model,@Valid Patient patient, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) return "formPatient";
	patientRepository.save(patient);
	model.addAttribute("patient", patient);
	return "Confirmation";
	}
}
