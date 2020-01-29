
fun main(args:Array<String>){

}

 class ChainHash<K,V>(val capacity:Int){
   //====================  クラスNode ===================================
    private class Node<K,V>(val key:K, val data:V, var next:Node<K,V>) {
            //キーのハッシュ値を返す
       override fun hashCode() = key.hashCode()
    }
    // ================================================================== //


    private var table:Array<Node<K,V>?>

    init {
            table = arrayOfNulls(capacity)
    }

    // -- ハッシュ値を求める -- //
    fun hashValue(key:K):Int  = key.hashCode() % this.capacity

    //-- キー値Keyを持つ要素の探索(データの返却) --//
    fun search(key:K) :V?{
        val hash = hashValue(key)
        var p:Node<K,V>? = table[hash]

        while (p != null){
            if(p.key?.equals(key)!!)
                return p.data
            else
                p=p.next
        }
        return null
    }

    //---- キー値Key. データdataを持つ要素の追加
    fun add(key:K, data:V):Int{
        val hashValue = hashValue(key)
        var p = table[hashValue]

        while(p != null){
            if(p.key!!.equals(key)){
                return 1
            }else
                p = p.next
        }
        val temp = Node<K,V>(key,data,table[hashValue]!!)
        table[hashValue] = temp
        return 0
    }

    // ---- キー値Keyを持つ要素の削除 ---//
    fun remove(key:K):Int{
        val hash = hashValue(key)
        var p:Node<K,V>? = table[hash]
        var pp:Node<K,V>? = null

        while(p != null) {
           if(p.key!!.equals(key)){
               if(pp ==null)
                   table[hash] = p.next
               else
                   pp.next = p.next
               return 0
           }
            pp = p
            p = p.next
        }
        return 1
    }
}
