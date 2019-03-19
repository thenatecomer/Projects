package comerlab7;
//Nathan Comer Lab 7

public class ComerLab7 {
    public static void main(String[] args) {
        Map MapTest = new Map(5,3);
        
        for(int i = 100; i>0 ; i--){
            MapTest.put(i, i%2);
        }
        
        System.out.println("");
        System.out.println("Test get:");
        System.out.println(MapTest.get(50)); //Should be 0
        System.out.println(MapTest.get(51)); //Should be 1
        
        System.out.println("");
        System.out.println("Test isIn:");
        System.out.println("Should be true: "+MapTest.isIn(95)+"          Should be false: "+MapTest.isIn(105));
        
        System.out.println("");
        System.out.println("Test put:");
        MapTest.put(3,"abc");
        System.out.println(MapTest.get(3)); //Should be abc
    }
}

class Map<Key, Value>{
    private int count = 0;
    private Key[] keys;
    private Value[] values;
    public int inc = 0;
    
    public Map(int length, int increment){
        if(length<0||increment<=0){
            throw new IllegalArgumentException("Invalid array length or increment");
        }
        keys = (Key[]) new Object[length];
        values = (Value[]) new Object[length];
        inc = increment;
    }
                  
    public Map(){
        new Map(64,8);
    }
        
    public Value get(Key key){
        for(int i = 0; i < keys.length; i++){
            if(keys[i]==key){
                return values[i];
            }
        }
        throw new IllegalStateException("Key not in map");
    }
            
    private boolean isEqual(Key leftKey, Key rightKey){
        return leftKey.equals(rightKey);
    }
               
    public boolean isIn(Key key){
        for(int i = 0; i <keys.length; i++){
            if(isEqual(key,keys[i])){
                return true;
            }
        }
        return false;
    }
               
    public void put(Key key, Value value){
        if(count>=keys.length){
            Key[] temp = (Key[]) new Object[keys.length+inc];
            Value[] tempv = (Value[]) new Object[values.length+inc];
            for(int i = 0; i<keys.length; i++){
                temp[i]=keys[i];
                tempv[i]=values[i];
            }
            keys = temp;
            values = tempv;
        }
        if(isIn(key)){
            values[where(key)]=value;
        }else{
            keys[count]=key;
            values[count]=value;
            count++; 
        }
    }
            
    private int where(Key key){
        for(int i = 0; i < keys.length; i++){
                if(keys[i]==key){
                    return i;
                }
            }
    return -1;
    }
}