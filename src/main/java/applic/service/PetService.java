package applic.service;

import applic.model.Pet;
import applic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public Pet addPet(Pet pet) {
        if (pet.getName() == null || pet.getName().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet with id " + id + " not found"));
        existingPet.setName(updatedPet.getName());
        existingPet.setAge(updatedPet.getAge());
        existingPet.setBreed(updatedPet.getBreed());

        return petRepository.save(existingPet);
    }
    public void deletePet(Long id) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet with id " + id + " not found"));
        petRepository.delete(existingPet);
    }
}
