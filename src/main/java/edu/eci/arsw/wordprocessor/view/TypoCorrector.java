/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.wordprocessor.view;

import java.util.LinkedHashMap;

/**
 *
 * @author dummyProgrammer
 */
public class TypoCorrector {
    
    private final LinkedHashMap<String, String> engEquivalencesMap;
    
    
    public TypoCorrector() {

        engEquivalencesMap = new LinkedHashMap<>();

        engEquivalencesMap.put("absolutly", "absolutely");
        engEquivalencesMap.put("absorbsion", "absorption");
        engEquivalencesMap.put("absorbtion", "absorption");
        engEquivalencesMap.put("abudance", "abundance");
        engEquivalencesMap.put("abundacies", "abundances");
        engEquivalencesMap.put("abundancies", "abundances");
        engEquivalencesMap.put("abundunt", "abundant");
        engEquivalencesMap.put("abutts", "abuts");
        engEquivalencesMap.put("acadamy", "academy");
        engEquivalencesMap.put("acadmic", "academic");
        engEquivalencesMap.put("accademic", "academic");

        
    }
    

    /**
     * Obj: Verificar que la palabra ingresada esté sujeta a correcciones, por
     * ejemplo por un error típico de digitación identificado.
     *
     * @param word
     * @param lang
     * @return
     */
    public String check(String word) {

        String res = engEquivalencesMap.get(word);
        if (res == null) {
            return null;
        } else {
            return res;
        }

    }

}
