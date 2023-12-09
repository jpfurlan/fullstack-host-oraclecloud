package br.com.campoamesa.service;

import br.com.campoamesa.DTO.UserByServedCityResponseDTO;
import br.com.campoamesa.model.UserId;
import br.com.campoamesa.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserIdService {
    @Autowired
    private UserIdRepository userIdRepository;

    public boolean userExists(String userId) {
        return userIdRepository.existsById(userId);
    }

    public boolean existsByEmail(String userId) {
        return userIdRepository.existsByEmail(userId);
    }

    public List<UserId> findProvider() { return userIdRepository.findProvider(); }

    public Optional<UserId> findById(String id) {
        return userIdRepository.findById(id);
    }

    public UserId save(UserId user) {
        return userIdRepository.save(user);
    }

    public void deleteById(String id) {
        userIdRepository.deleteById(id);
    }

    public List<UserId> findByState(String state) { return userIdRepository.findByState(state); }

    public List<UserId> findByCitie(String citie) { return userIdRepository.findByCity(citie); }

    public void setAvatar(String id, String avatar) {
        userIdRepository.setAvatar(id, avatar);
    }


}
