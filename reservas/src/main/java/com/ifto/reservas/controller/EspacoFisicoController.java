package com.ifto.reservas.controller;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@RestController
@RequestMapping("/api/espaco")
public class EspacoFisicoController {

    @Autowired
    EspacoFisicoRepository espacoFisicoRepository;

    @GetMapping("/list")
    public ModelAndView form (EspacoFisico espacoFisico, ModelMap model){
        model.addAttribute("espaco", espacoFisico);
        return new ModelAndView();
    }

}
