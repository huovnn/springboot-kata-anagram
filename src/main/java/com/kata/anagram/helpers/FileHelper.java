/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kata.anagram.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tapio
 */
public class FileHelper {
    
    public List<String> getLines() {
       List<String> lines = new ArrayList<String>();
       
       try {
          
           
           BufferedReader reader = new BufferedReader(new java.io.FileReader("exp-words.txt"));
           
           String line = null;
           while((line = reader.readLine()) != null) {
               lines.add(line.toLowerCase());
           }
          
       }
       catch(IOException e) {
           System.err.println("Error :"+e);
       }
       
       return lines;
    };
}
