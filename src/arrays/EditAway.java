package arrays;
public class EditAway {
	
	public boolean isOneEditAway(String s, String t) {
		boolean difffound = false;
		int index1 =0;
		int index2 = 0;
		if(Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		while(index1 < s.length() && index2 < t.length()) {
			if(s.charAt(index1) != t.charAt(index2)) {
				if(difffound)
					return false;
				difffound = true;
				if(s.length()==t.length()) {
					index1++;
					index2++;
				}
				else if(s.length() > t.length()) {
					index1++;
				}
				else {
					index2++;
				}
			}
			else {
				index1++;
				index2++;
			}
		}
		return true;
	}
}
