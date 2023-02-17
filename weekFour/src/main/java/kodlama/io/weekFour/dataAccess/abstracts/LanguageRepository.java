package kodlama.io.weekFour.dataAccess.abstracts;

import java.util.List;

import kodlama.io.weekFour.entities.concretes.Language;


public interface LanguageRepository {
	List<Language> getAll();
	void addLanguages(Language language);
	void deleteLanguage(int id);
	void updateLanguge(Language existLanguage, Language newLanguage);
	Language getLanguageById(int id);
	
}
