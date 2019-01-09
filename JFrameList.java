/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadevs;

import java.util.LinkedList;
/**
 *
 * @author pand1
 */
public class JFrameList {
    public static LinkedList<LinkedList<String>> mainList = 
			new LinkedList<LinkedList<String>>();
    
    public LinkedList<LinkedList<String>> getList() {
       return this.mainList;
    }
    
    public void setList (LinkedList<LinkedList<String>> mainList) {
        this.mainList = mainList;
    }
    
}
