package io.neetcode.solution.code;

import java.util.HashMap;
import java.util.Map;

public class StringBundle {
	
    public String longestPalindrome(String s) {
    	int maxpalindrom = 0;
    	String ans = "";
    	for(int i=0; i<s.length(); i++)
    		for(int j=i; j<s.length(); j++) {
    			int l = i, r = j;
    			while (l < r && s.charAt(l)==s.charAt(r)) {
    				l ++;
    				r --;
    			}
    			if(l>=r && maxpalindrom < (j-i+1)) {
  					maxpalindrom = j-i+1;
   					ans = s.substring(i, j+1);  
    			}
    		}
        return ans;	
    }
    
    public int countSubstrings(String s) {
    	int counter = 0;
    	for(int i=0; i<s.length(); i++)
    		for(int j=i; j<s.length(); j++) {
    			int l = i, r = j;
    			while (l < r && s.charAt(l)==s.charAt(r)) {
    				l ++;
    				r --;
    			}
    			if(l>=r) counter++;
    		}
        return counter;	
    }
    public int numDecoding(String s, int i, Map<Integer, Integer> map ) {
    	if (map.containsKey(i)) return map.get(i);
    	if (i==s.length()) return 1;
    	if (s.charAt(i)=='0') return 0;
    	int res = numDecoding(s,i+1, map);
    	if (i < (s.length()-1)) 
    		if (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))
    			res+=numDecoding(s,i+2, map);
    	map.put(i, res);
    	return res;
    }
    public int numDecodings(String s) {
    	Map<Integer, Integer> map = new HashMap<>();
    	return numDecoding(s, 0, map);
    }
    
    

}
