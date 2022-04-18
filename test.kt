fun main(args: Array<String>) {
   val trainList = mapOf(
      '0' to mutableListOf("Charminar Express","Tambaram", "Hyderabad","9"),
      '1' to mutableListOf("Ananya Express", "Sealdah", 	"Udaipur","10"),
      '2' to mutableListOf("Avantika Express", "Indore Jn", "Mumbai Central","11")
   )
   
   var filterKey : String = args[0];
   var filterVal : String = args[1];
   
   val getIndex: Int = when(filterKey) {
         "name" -> 0
         "source" -> 1
         "destination" -> 2
         "time" -> 3
         else -> -1
     }
    
   var result: Boolean = false
   
   for ((index, trainDetails) in trainList) {
       result = findTrains(filterVal, getIndex, trainDetails);
        if(result){
              println(trainDetails)
         }
    }      
}

fun findTrains(value: String, index: Int, train: MutableList<String>): Boolean {
    for (arrIndex in train.indices) {
        if(arrIndex === index && train[arrIndex].lowercase() == value.lowercase()) {
        	return true
        }
    }
    return false
}
