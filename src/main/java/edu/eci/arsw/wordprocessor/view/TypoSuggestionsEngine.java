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
public class TypoSuggestionsEngine {

    private final LinkedHashMap<String, String> spaEquivalencesMap;
    private final LinkedHashMap<String, String> engEquivalencesMap;
    
    private final LinkedHashMap<Languages, LinkedHashMap<String, String>> langMaps;    
    private LinkedHashMap<String,String> selectedTyposMap;
    
    public TypoSuggestionsEngine() {
        spaEquivalencesMap = new LinkedHashMap<>();

        spaEquivalencesMap.put("hoal", "hola");
        spaEquivalencesMap.put("yola", "hola");
        spaEquivalencesMap.put("jola", "hola");
        spaEquivalencesMap.put("hol", "hola");
        spaEquivalencesMap.put("vuenas", "buenas");
        spaEquivalencesMap.put("nuenas", "buenas");
        spaEquivalencesMap.put("huenas", "buenas");
        spaEquivalencesMap.put("pocible", "posible");

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

        langMaps = new LinkedHashMap<>();
        langMaps.put(Languages.SPANISH, spaEquivalencesMap);
        langMaps.put(Languages.ENGLISH, engEquivalencesMap);
        
        //default languange: English
        selectedTyposMap = engEquivalencesMap;
        
    }


    public void setSelectedLanguage(Languages selectedLanguage) {
        selectedTyposMap=langMaps.get(selectedLanguage);
    }
    

    /**
     * Obj: Verificar que la palabra ingresada esté sujeta a correcciones, por
     * ejemplo por un error típico de digitación identificado.
     *
     * @param word
     * @param lang
     * @return
     */
    public String check(String word, Languages lang) {

        String res = selectedTyposMap.get(word);
        if (res == null) {
            return null;
        } else {
            return res;
        }

    }

}
