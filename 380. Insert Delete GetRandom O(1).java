class RandomizedSet {
    private Map<Integer, /*Index of ArrayList*/ Integer> map;
    List<Integer> list;
    Random random;
    
    public RandomizedSet() {
        // Initialization Done
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int removeIndex = map.get(val);
        map.remove(val);
        if((removeIndex + 1) == list.size()){
            list.remove(removeIndex);
            return true;
        }
        
        list.set(removeIndex, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        
        map.put(list.get(removeIndex), removeIndex);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex); 
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
