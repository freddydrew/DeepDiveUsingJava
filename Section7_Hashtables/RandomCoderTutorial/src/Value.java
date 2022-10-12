public class Value {

    private int Value;

    public Value(int v){
        Value = v;
    }

    public int getValue(){
        return Value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Value Value1 = (Value) o;
        return Value == Value1.Value;
    }
}
