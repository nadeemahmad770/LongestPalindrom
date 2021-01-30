public class LongestPalindrom {
	public static void main(String[] args) {
		LongestPalindrom pd = new LongestPalindrom();
		String inputStr = "HelloWelcomeemoclewHelloolle".toLowerCase();
		String pal = pd.findLongestPalindrome(inputStr);
		System.out.println(pal);
	}

	public String findLongestPalindrome(String s) {
  
		if (s.isEmpty()) {
			return "Please enter a String";
		}

		if (s.length() == 1) {
			return s;
		}
		
		// Start with one char as a longest palindrome
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i = i + 1) {
			// get longest palindrome for odd length and center is i only one char
			String tmp = checkEquality(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome for even length and center is i, i+1 two chars
			tmp = checkEquality(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	public String checkEquality(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
}
