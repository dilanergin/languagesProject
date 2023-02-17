package kodlama.io.weekFour.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.weekFour.dataAccess.abstracts.LanguageRepository;
import kodlama.io.weekFour.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languagess;
	
	public InMemoryLanguageRepository() {
		languagess = new ArrayList<>();
		languagess.add(new Language(1, "C#"));
		languagess.add(new Language(2, "Java"));
		languagess.add(new Language(3, "Phyton"));
		languagess.add(new Language(4, "Html"));
		
	}

	@Override
	public List<Language> getAll() {
		
		return languagess;
	}

	@Override
	public void addLanguages(Language language) {
		languagess.add(language);
		
	}

	@Override
	public void deleteLanguage(int id) {
		languagess.remove(id);
	}

	@Override
	public void updateLanguge(Language existLanguage, Language newLanguage) {
		languagess.set(existLanguage.getId(), newLanguage);
	}

	@Override
	public Language getLanguageById(int id) {
		return languagess.get(id);
			
	}

}
