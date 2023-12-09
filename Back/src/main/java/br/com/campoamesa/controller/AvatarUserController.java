package br.com.campoamesa.controller;

import br.com.campoamesa.model.AvatarUser;
import br.com.campoamesa.model.UserId;
import br.com.campoamesa.service.AvatarUserService;
import br.com.campoamesa.service.UserIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AvatarUserController {

    private AvatarUserService avatarUserService;
    private UserIdService userIdService;


}
