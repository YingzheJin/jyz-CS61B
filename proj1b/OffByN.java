public class OffByN implements CharacterComparator {
    private int numb;

    public OffByN(int N) {
        numb = N;
    }


    @Override
    public boolean equalChars(char x, char y){
        return x - y == numb || x - y == -numb;
    }
}
