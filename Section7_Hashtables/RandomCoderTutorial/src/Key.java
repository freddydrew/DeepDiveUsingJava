import java.util.Objects;

public class Key {


    private int Key;

    public Key(int k){
        Key = k;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        } else if (o == null ||getClass() != o.getClass()) {
            return false;
        }
        Key Key1 = (Key) o;
        return Objects.equals(Key,Key1.Key);
    }

    @Override
    public int hashCode(){
        return Objects.hash(Key);
    }
}
