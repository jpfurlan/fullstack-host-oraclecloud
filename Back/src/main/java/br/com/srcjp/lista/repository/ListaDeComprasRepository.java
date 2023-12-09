package br.com.srcjp.lista.repository;

import br.com.srcjp.lista.model.ItemLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeComprasRepository extends JpaRepository<ItemLista, Long> {
}
