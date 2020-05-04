package algo.strings;

public class MaxDistinctSubString {
  static final int NO_OF_CHARS = 26;

  static int longestUniqueSubString(String str) {
    int curLen = 1; // length of current substring
    int maxLen = 1; // result
    int prevIndex; // previous index
    int visited[] = new int[NO_OF_CHARS];

    for (int i = 0; i < NO_OF_CHARS; i++) {
      visited[i] = -1;
    }

    visited[str.charAt(0) - 'a'] = 0;

    for (int i = 1; i < str.length(); i++) {
      int currIndex = str.charAt(i) - 'a';
      prevIndex = visited[currIndex];
      if (prevIndex == -1 || (i - curLen) > prevIndex) {
        curLen++;
      } else {
        maxLen = Math.max(curLen, maxLen);
        curLen = i - prevIndex;
      }
      visited[currIndex] = i;
    }
    return Math.max(curLen, maxLen);
  }

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    int len = longestUniqueSubString(str);
    System.out.println("The length of the longest non repeating character is: " + len);
  }
}
