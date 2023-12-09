package br.com.campoamesa.repository;

import br.com.campoamesa.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExplorerFilterRepository extends JpaRepository<UserId, String> {

    @Query("SELECT u FROM UserId u JOIN u.servedCities sc WHERE sc IN :cities")
    List<UserId> findUserIdsByServedCities(@Param("cities") List<String> cities);

    // Para encontrar usuários por cidades atendidas excluindo um determinado usuário
    @Query("SELECT u FROM UserId u JOIN u.servedCities sc WHERE sc IN :cities AND u.id != :excludeUserId")
    List<UserId> findUserIdsByServedCitiesExcludingUser(
            @Param("cities") List<String> cities,
            @Param("excludeUserId") String excludeUserId);

    // Para encontrar todos os usuários excluindo um determinado usuário
    List<UserId> findByIdNot(String excludeUserId);




}
