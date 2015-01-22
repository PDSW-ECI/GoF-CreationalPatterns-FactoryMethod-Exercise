/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.wordprocessor.view;

import java.util.LinkedHashMap;

/**
 *
 * @author hcadavid
 */
public class TypoSuggestionsEngine {

	final static LinkedHashMap<String,String> equivalencesMap;
        
        static{		
		equivalencesMap=new LinkedHashMap<>();		
		
		equivalencesMap.put("hoal", "hola");
		equivalencesMap.put("yola", "hola");
		equivalencesMap.put("jola", "hola");
		equivalencesMap.put("hol", "hola");
		equivalencesMap.put("vuenas", "buenas");
		equivalencesMap.put("nuenas", "buenas");
		equivalencesMap.put("huenas", "buenas");
                equivalencesMap.put("pocible", "posible");
				
	}
    
	/**
	 * Obj: Verificar que la palabra ingresada esté sujeta a correcciones, por ejemplo
	 * por un error típico de digitación identificado.	
	 * @param word
	 * @return
	 */
	public String check(String word){
		String res=equivalencesMap.get(word);
		if (res==null){
			return null;
		}
		else{
			return res;
		}
		
	}
	
	
}
