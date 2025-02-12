package com.doku.string;

public class StringLib {

		public boolean isPalindrome(String s) {
			if(s.isEmpty()) return false;
			for (int l=0, r=s.length()-1; l<r; l++,r--)
				if(s.charAt(l)!=s.charAt(r)) return false;
			return true;
		}
}
