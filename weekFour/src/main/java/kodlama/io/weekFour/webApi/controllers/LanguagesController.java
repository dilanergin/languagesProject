package kodlama.io.weekFour.webApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.weekFour.business.abstracts.LanguageService;
import kodlama.io.weekFour.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages ")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping(
            value = "/insertNewLanguage",
            consumes = "application/json",
            produces = "application/json"
    )
    public void insertNewLanguage(@RequestBody Language language){
        languageService.addLanguages(language);
    }

	@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Language getLanguageId(@PathVariable("id") int id) {
		
		return languageService.getLanguageById(id);
	}
	
	@DeleteMapping("/deleteLanguage/{id}")
	public void deleteLanguage(@PathVariable("id" )int id) {
		languageService.deleteLanguage(id);
	}
	
	
}
