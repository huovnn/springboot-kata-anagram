/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kata.anagram.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tapio
 */
public class AnagramHelper {

    private FileHelper fileHelper = null;
    private List<String> wordList = null;

    public AnagramHelper(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
        this.wordList = this.fileHelper.getLines();
        
    }

    public List<String> findAnagrams(String baseCase, int wordCombination) {
        List<String> results = new ArrayList<String>();
        if (wordCombination == 1) {
            List<String> filteredWordList = filterOneWord(baseCase, wordList);
            results = findOneWordCombinations(baseCase, filteredWordList);
            
        }
        else if (wordCombination == 2) {
            List<String> filteredWordList = filterTwoWord(baseCase, wordList);
            results = findTwoWordCombinations(baseCase, filteredWordList);
        }
        
        
        return results;
        
    }
    
    
    private List<String> findOneWordCombinations(String baseCase, List<String> filteredWordList) {
        int anagramCount = 0;
        List<String> anagrams = new ArrayList<String>();
        for (int i = 0; i < filteredWordList.size(); i++) {
            String wordListLine = filteredWordList.get(i);
            
            if (sorted(baseCase).equals(sorted(wordListLine))) {
                // anagram found
                anagrams.add(wordListLine);
                anagramCount++;
                System.out.println(baseCase + " : " + wordListLine);
            }
        }
        
        System.out.println(anagramCount + " anagrams found");
        
        return anagrams;
    }
    
    private List<String> findTwoWordCombinations(String baseCase, List<String> filteredWordList) {
        int anagramCount = 0;
        List<String> anagrams = new ArrayList<String>();
        
        for (int i = 0; i < filteredWordList.size(); i++) {

            String firstLine = filteredWordList.get(i);
            for (int j = 0; j < filteredWordList.size(); j++) {

                // skip same words
                if (j != i) {
                    String secondLine = filteredWordList.get(j);

                    String combined = combineStrings(firstLine, secondLine);

                    if (sorted(baseCase).equals(sorted(combined))) {
                        // anagram found
                        anagramCount++;
                        System.out.println(baseCase + " : " + firstLine + " " + secondLine);
                        anagrams.add(firstLine + " " + secondLine);
                    }
                }
            }
        }
        System.out.println(anagramCount + " anagrams found");
        return anagrams;
    }

    private String combineStrings(String first, String second) {
        StringBuilder sb = new StringBuilder(80);
        sb.append(first);
        sb.append(second);

        return sb.toString();
    }

    private String sorted(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        
        return sorted;
    }
    
    private List<String> filterOneWord(String baseCase, List<String> originalWordList) {
        List<String> filteredList = new ArrayList<String>();
        
        for (int i = 0; i < originalWordList.size(); i++) {
            String line = originalWordList.get(i);
            
            if (line.length() == baseCase.length()) {
                filteredList.add(line);
            }
        }
        
        printFilteredAmount(filteredList, originalWordList);
        return filteredList;
    }

    private List<String> filterTwoWord(String baseCase, List<String> originalWordList) {
        char[] baseChars = baseCase.toCharArray();
        List<String> filteredLines = new ArrayList<String>();
        Boolean flag = true;

        for (int i = 0; i < originalWordList.size(); i++) {
            String line = originalWordList.get(i);
            
            // since we are trying to compare two separate words, there is no point 
            // to keep lines that are longer or equal
            if (line.length() < baseCase.length()) {
                char[] lineChars = line.toCharArray();

                for (int j = 0; j < lineChars.length; j++) {
                    String character = Character.toString(lineChars[j]);
                    if (baseCase.contains(character)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    filteredLines.add(line);
                }
            }
        }
        
        printFilteredAmount(filteredLines, originalWordList);
        return filteredLines;
    }
    
    private void printFilteredAmount(List<String> filtered, List<String> original) {
        System.out.println("---------------------------------------------------");
        System.out.println("Original list size: " + original.size());
        System.out.println("Filtered list size: " + filtered.size());
        int amount = original.size() - filtered.size();
        System.out.println("Filtered " + amount + " word(s)");
        System.out.println("---------------------------------------------------");
    }

}

