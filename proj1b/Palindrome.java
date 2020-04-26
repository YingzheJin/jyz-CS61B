public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> worddeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            worddeque.addLast(word.charAt(i));
        }
        return worddeque;
    }

    private boolean isPalindrome(Deque D) {
        if (D.size() <= 1){
            return true;
        }
        if (D.removeFirst() == D.removeLast()) {
            return isPalindrome(D);
        }
        return false;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> checkdeque = wordToDeque(word);
        return isPalindrome(checkdeque);
    }

    private boolean isPalindrome(Deque<Character> D, CharacterComparator cc) {
        if (D.size() <= 1){
            return true;
        }
        if (cc.equalChars(D.removeFirst(), D.removeLast())) {
            return isPalindrome(D, cc);
        }
        return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> checkobodeque = wordToDeque(word);
        return isPalindrome(checkobodeque, cc);
    }
}

