package br.com.srcjp.lista.service;

import br.com.srcjp.lista.dto.ItemListaDTO;
import br.com.srcjp.lista.model.ItemLista;
import br.com.srcjp.lista.repository.ListaDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaDeComprasService {

    private final ListaDeComprasRepository repository;

    @Autowired
    public ListaDeComprasService(ListaDeComprasRepository repository) {
        this.repository = repository;
    }

    public List<ItemListaDTO> getAllItems() {
        return repository.findAll().stream()
                .map(item -> new ItemListaDTO(item.getId(),item.getNome(), item.getQuantidade()))
                .collect(Collectors.toList());
    }

    public ItemListaDTO addItem(ItemListaDTO itemDTO) {
        ItemLista item = new ItemLista(itemDTO.nome(), itemDTO.quantidade());
        item = repository.save(item);
        return new ItemListaDTO(item.getId(),item.getNome(), item.getQuantidade());
    }

    public ItemListaDTO updateItem(Long id, ItemListaDTO itemDTO) {
        ItemLista existingItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com id: " + id));
        existingItem.setNome(itemDTO.nome());
        existingItem.setQuantidade(itemDTO.quantidade());
        existingItem = repository.save(existingItem);
        return new ItemListaDTO(existingItem.getId() ,existingItem.getNome(), existingItem.getQuantidade());
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}