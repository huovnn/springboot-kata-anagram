/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kata.anagram.models;

import java.util.List;

/**
 *
 * @author Tapio
 */
public class AnagramModel {
    private String word;
    private int combination;
    private List<String> anagrams;
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCombination() {
        return combination;
    }

    public void setCombination(int combination) {
        this.combination = combination;
    }

    public List<String> getAnagrams() {
        return anagrams;
    }

    public void setAnagrams(List<String> originalList) {
        this.anagrams = originalList;
    }
    
    
}
