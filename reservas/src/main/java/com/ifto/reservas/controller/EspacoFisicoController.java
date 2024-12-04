package com.ifto.reservas.controller;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.repository.GenericRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("espaco")
public class EspacoFisicoController {

    @Autowired
    GenericRepository genericRepository;

    @GetMapping("/form")
    public ModelAndView form (EspacoFisico espacoFisico, ModelMap model){
        model.addAttribute("espaco", espacoFisico);
        return new ModelAndView();
    }

}
