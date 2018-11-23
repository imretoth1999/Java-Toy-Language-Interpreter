package model;

import java.util.Hashtable;

public class MyDictionary<TKey, TValue> implements MyIDictionary<TKey, TValue> {

    Hashtable<TKey,TValue> dict;

    public MyDictionary() {
        dict = new Hashtable<TKey, TValue>();
    }

    public MyDictionary(Hashtable<TKey,TValue> dict) {
        this.dict = dict;
    }
    @Override
    public String toString(){
        String msg="";
        for(TKey key : dict.keySet())
            msg+=key.toString()+" = "+dict.get(key).toString()+'\n';
        return msg;

    }

    @Override
    public void put(TKey key, TValue value) {
        dict.put(key, value);
    }

    @Override
    public void remove(TKey key) throws MyDataException {
        containsKey(key);
        dict.remove(key);
    }

    @Override
    public TValue get(TKey key) throws MyDataException {
        containsKey(key);
        return dict.get(key);
    }

    @Override
    public boolean containsKey(TKey key) throws MyDataException {
        if(!dict.containsKey(key))
            throw new MyDataException("No  key: "+key.toString());
        return true;
    }

    @Override
    public boolean containsValue(TValue value) throws MyDataException {
        if(!dict.containsValue(value))
            throw new MyDataException("No  value: "+value.toString());
        return true;
    }

}
