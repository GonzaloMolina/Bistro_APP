package Bistro_BackEnd.model.pair;

public class Pair {

    private Integer key;
    private Integer amount;

    public Pair(){}

    public Pair(Integer key, Integer amount){
        this.key = key;
        this.amount = amount;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
