package kodlama.io.weekFour.business.abstracts;

import java.util.List;

import kodlama.io.weekFour.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	void addLanguages(Language language);
	void deleteLanguage(int id);
	void updateLanguge(Language existLanguage, Language newLanguage);
	Language getLanguageById(int id);
	void isNameEmpty(Language language);
	void isNameAlreadyExist(Language language);
}
