package br.com.srcjp.lista.dto;

import br.com.srcjp.lista.model.ItemLista;

public record ItemListaDTO(Long id, String nome, String quantidade) {

    public ItemListaDTO(ItemLista itemLista) {
        this(itemLista.getId(), itemLista.getNome(), itemLista.getQuantidade());
    }
}