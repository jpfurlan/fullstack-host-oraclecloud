package br.com.campoamesa.repository;

import br.com.campoamesa.DTO.UserByServedCityResponseDTO;
import br.com.campoamesa.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserIdRepository extends JpaRepository<UserId, String> {
    boolean existsByEmail(String email);

    @Query("SELECT u FROM UserId u WHERE u.isProvider = true")
    List<UserId> findProvider();

    @Query("SELECT u FROM UserId u WHERE u.state = ?1")
    List<UserId> findByState(String state);

    @Query("SELECT u FROM UserId u WHERE u.city = ?1")
    List<UserId> findByCity(String city);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserId e SET e.avatar = ?2 WHERE e.id = ?1")
    void setAvatar(String id, String avatar);

}
