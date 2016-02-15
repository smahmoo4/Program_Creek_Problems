import java.util.*;

class IsomorphicStrings {
	
	//PROBLEM 3
	/*

	Given two strings s and t, determine if they are isomorphic. 
	Two strings are isomorphic if the characters in s can be replaced to get t, and vice versa.

	For example,"egg" and "add" are isomorphic, because
		e -> a;
		g -> d;
		
		conversely, 
		
		a -> e;
		d -> g;
		
		
	"foo" and "bar" are not.
	
		f -> b;
		o -> a;
		o -> r;
	
		'o' cannot be replaced by multiple characters, therefore this pair of strings are not isomorphic
	
	*/
	
	public static void main(String[] args) {
		System.out.println(isIsomorphicString("", ""));
	}
	
	public static boolean isIsomorphicString(String s, String t) {
		if(s == null || t == null)
			return false;
		
		if(s.length()!=t.length())
			return false;
		
		if(s.length() == 0 && t.length() == 0)
			return true;
		
		HashMap<Character,Character> map = new HashMap<Character, Character>();
		HashMap<Character,Character> map2 = new HashMap<Character,Character>();
		
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);		
			char d = t.charAt(i);
			
			//check s -> t isomorphic?
			if(!map.containsKey(c))
				map.put(c, t.charAt(i));
			
			else {
				if(map.get(c) != t.charAt(i))
					return false;
			}

			//check t -> s isomorphic?
			if(!map2.containsKey(d))
				map.put(d, s.charAt(i));
			else {
				if(map.get(d) != s.charAt(i))
					return false;
			}
		}
		
		return true;
	}
}