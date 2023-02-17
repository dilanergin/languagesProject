package kodlama.io.weekFour.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.weekFour.business.abstracts.LanguageService;
import kodlama.io.weekFour.dataAccess.abstracts.LanguageRepository;
import kodlama.io.weekFour.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService  {

	private LanguageRepository languageRepository;
	private final String alertA="PROGRAMLAMA DİLİ BOŞ OLAMAZ";
	private final String alertB="BU İSİM DAHA ÖNCE KAYDEDİLMİŞ";
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	@Override
	public List<Language> getAll() {		
	return languageRepository.getAll();
	}

	@Override
	public void addLanguages(Language language) {
		isNameEmpty(language);
		isNameAlreadyExist(language);
		languageRepository.addLanguages(language);
	}

	@Override
	public void deleteLanguage(int id) {
		languageRepository.deleteLanguage(id);
	}

	@Override
	public void updateLanguge(Language existLanguage, Language newLanguage) {
		isNameEmpty(newLanguage);
		languageRepository.updateLanguge(existLanguage, newLanguage);
	}
	

	@Override
	public Language getLanguageById(int id) {
		languageRepository.getLanguageById(id);
		return null;
	}

	@Override
	public void isNameEmpty(Language language) {
		
		if(language.getName().isEmpty()) {
			try {
				throw new Exception(alertA);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void isNameAlreadyExist(Language language) {
		List<Language> allLangguages = languageRepository.getAll();
		for(Language l:allLangguages) {
			if(l.getName().equals(language.getName())) {
				try {
					throw new Exception(alertB);
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
