/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kata.anagram.controllers;

import com.kata.anagram.helpers.AnagramHelper;
import com.kata.anagram.helpers.FileHelper;
import com.kata.anagram.models.AnagramModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tapio
 */
@Controller
public class AnagramController {
    
    private AnagramHelper anagramHelper = new AnagramHelper(new FileHelper());
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("anagram", new AnagramModel());
        AnagramHelper anagram = new AnagramHelper(new FileHelper());
        
        return "index";
    }

    @RequestMapping(value = "/anagrams", method = RequestMethod.POST)
    public String anagramSubmit(@ModelAttribute AnagramModel anagram, Model model) {
        String baseCase = anagram.getWord();
        int combinations = anagram.getCombination();
        anagram.setAnagrams(anagramHelper.findAnagrams(baseCase, combinations));
        model.addAttribute("anagram", anagram);
        
        return "anagrams";
    }
}
