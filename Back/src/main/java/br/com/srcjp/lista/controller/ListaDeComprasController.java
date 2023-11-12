package br.com.srcjp.lista.controller;

import br.com.srcjp.lista.dto.ItemListaDTO;
import br.com.srcjp.lista.service.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaDeComprasController {

    private final ListaDeComprasService service;

    @Autowired
    public ListaDeComprasController(ListaDeComprasService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping
    public List<ItemListaDTO> getAllItems() {
        return service.getAllItems();
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<ItemListaDTO> addItem(@RequestBody ItemListaDTO itemDTO) {
        ItemListaDTO newItem = service.addItem(itemDTO);
        return ResponseEntity.ok(newItem);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<ItemListaDTO> updateItem(@PathVariable Long id, @RequestBody ItemListaDTO itemDTO) {
        ItemListaDTO updatedItem = service.updateItem(id, itemDTO);
        return ResponseEntity.ok(updatedItem);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
