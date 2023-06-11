package richie.belt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.belt.models.Character;
import richie.belt.models.User;
import richie.belt.repositories.CharacterRepository;
import richie.belt.repositories.UserRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public boolean nameExists(String name) {
        Character character = characterRepository.findByName(name);
        return character != null;
    }

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }
    

    public List<Character> getAllCharacters() {
        return (List<Character>) characterRepository.findAll();
    }

    public Character getOneCharacter(Long id) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        return optionalCharacter.orElse(null);
    }

    public List<Character> findByUserId(Long userId) {
        return characterRepository.findByUserId(userId);
    }

    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    public void updateCharacter(Character character) {
        characterRepository.save(character);
    }

    public boolean hasUserUpvotedCharacter(User user, Character character) {
        List<User> upvoters = character.getUpvoters();
        for (User upvoter : upvoters) {
            if (upvoter.getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }
    
    
}

