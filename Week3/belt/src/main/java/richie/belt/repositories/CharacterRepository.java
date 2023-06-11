package richie.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.belt.models.Character;

public interface CharacterRepository extends CrudRepository<Character, Long> {
    List<Character> findAll();
    List<Character> findByUserId(Long userId);
    public Character findByName(String name);
}
