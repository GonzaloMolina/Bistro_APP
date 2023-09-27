package Bistro_BackEnd.model.pair;

import java.util.List;

public class PairPlatoAcom {

    private Integer key;
    private List<Integer> values;

    public PairPlatoAcom(){}

    public PairPlatoAcom(Integer key, List<Integer> values){
        this.key = key;
        this.values = values;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
