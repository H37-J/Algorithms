package datastructures.heap;

public class HeapElement {
    private final double key;
    private final Object additionalInfo;

    public HeapElement(double key,Object info){
        this.key=key;
        this.additionalInfo=info;
    }

    public HeapElement(int key, Object info) {
        this.key = key;
        this.additionalInfo = info;
      }
    
      /**
       * @param key : a number of object type 'Integer'
       * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
       *     additional information of use for the user
       */
      public HeapElement(Integer key, Object info) {
        this.key = key;
        this.additionalInfo = info;
      }
    
      /**
       * @param key : a number of object type 'Double'
       * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
       *     additional information of use for the user
       */
      public HeapElement(Double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
      }
    
      /** @param key : a number of primitive type 'double' */
      public HeapElement(double key) {
        this.key = key;
        this.additionalInfo = null;
      }
    
      /** @param key : a number of primitive type 'int' */
      public HeapElement(int key) {
        this.key = key;
        this.additionalInfo = null;
      }
    
      /** @param key : a number of object type 'Integer' */
      public HeapElement(Integer key) {
        this.key = key;
        this.additionalInfo = null;
      }
    
      /** @param key : a number of object type 'Double' */
      public HeapElement(Double key) {
        this.key = key;
        this.additionalInfo = null;
      }

      public Object getInfo() {
        return additionalInfo;
      }
    
      /** @return the key value of the element */
      public double getKey() {
        return key;
      }
    
      // Overridden object methods
    
      public String toString() {
        return "Key: " + key + " - " + additionalInfo.toString();
      }

      @Override
      public boolean equals(Object o){
          if(o!=null){
              if(!(o instanceof HeapElement)) return false;
              HeapElement otherHeapElement = (HeapElement) o;
              return (this.key==otherHeapElement.key)
               && (this.additionalInfo.equals(otherHeapElement.additionalInfo));
          }
          return false;
      }

      @Override
      public int hashCode() {
        int result = 0;
        result = 31 * result + (int) key;
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        return result;
      }

}
