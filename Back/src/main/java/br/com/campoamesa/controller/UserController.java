package br.com.campoamesa.controller;

import br.com.campoamesa.DTO.UserByServedCityRequestDTO;
import br.com.campoamesa.DTO.UserByServedCityResponseDTO;
import br.com.campoamesa.model.AvatarUser;
import br.com.campoamesa.model.UserId;
import br.com.campoamesa.service.UserIdService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserIdService userService;
    @CrossOrigin
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<UserId> saveId(@RequestBody UserId userId){
        if (userService.existsByEmail(userId.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (userService.userExists(userId.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(userId));
    }

    @CrossOrigin
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserId> getUserId(@PathVariable String id) {
        UserId userId = userService.findById(id).orElse(null);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.ok(userId);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<UserId> updateId(@PathVariable String id, @RequestBody UserId userId) {
        Optional<UserId> existingUser = userService.findById(id);

        if (existingUser.isPresent()) {
            userService.save(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteId(@PathVariable String id) {
        if (!userService.userExists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @GetMapping("/findProvider")
    public List<UserId> findProvider() {
        return userService.findProvider();
    }

    @CrossOrigin
    @PostMapping("/avatar")
    public ResponseEntity<UserId> saveAvatar(@RequestBody AvatarUser avatarUser) {
        UserId userId = userService.findById(avatarUser.getProviderId()).orElse(null);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        userService.setAvatar(userId.getId(), avatarUser.getUrlAvatar());
        UserId userIdAfter = userService.findById(avatarUser.getProviderId()).orElse(null);

        return new ResponseEntity<>(userIdAfter, HttpStatus.CREATED);
    }




}
