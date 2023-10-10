package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiUtilisateur {

    @PostMapping(value = Api+"/utilisation")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);


}


