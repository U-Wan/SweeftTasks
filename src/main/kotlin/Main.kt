package sweeft

import sweeft.linkedlist.LinkedList

//N1
fun isPalindrome(text:String):Boolean {
    var k = text.length - 1
    for (i in 0 until k) {
        if (text[i] != text[k]) return false
        k--
    }
    return true

    //second way
    //  return text==text.reversed()
}

//N2
fun minSplit(amount:Int):Int{

    //1,5,10,20,50
    var sum=0
    var x=amount
    sum+=amount/50
    x%=50
    sum+=x/20
    x%=20
    sum+=x/10
    x%=10
    sum+=x/5
    x%=5
    sum+=x/1
    x%=1

    return sum

//second way
/*    val array = intArrayOf(1, 5, 10, 20, 50)
    var x = amount
    var sum = 0
    var rest: Int
    rest = x
    var k = 4
    while (x > 0) {
        if (rest < array[k]) k--
        if (rest >= array[k]) {
            sum += x / array[k]
            rest = x % array[k]
            x = rest
        }
    }
    return sum*/
}

//3
fun notContains(array: Array<Int>): Int {

    var min = array.size
    var set: MutableSet<Int> = HashSet()

    for (i in array) {
        if (i > 0) {
            set.add(i)
        }
    }
    for (k in 1..min) {
        if (!set.contains(k)) {
            return k
        }
    }
    return min + 1

}

//4
fun isProperly(sequence: String):Boolean{
    var count=0
    for(i in 0 until sequence.length){
        if(sequence[i]=='('){
            count++
        }else if(sequence[i]==')'){
            count--
        }
        if(count<0){
            return false
        }
    }

    return count==0
}

//5
fun countVariants(strearsCount:Int): Int {

    //Way1
    var steps= IntArray(strearsCount+1)
    steps[0]=1
    steps[1]=1

    for(i in 2..strearsCount){
        steps[i]=steps[i-1]+steps[i-2]
    }
    return steps[strearsCount]


//way2

/*if (strearsCount <= 0) return 0
    if (strearsCount === 1) return 1
    if (strearsCount === 2) return 2

    var oneStepBefore = 2
    var twoStepBefore = 1
    var allWays = 0

    for (i in 2 until strearsCount) {
        allWays = oneStepBefore + twoStepBefore
        twoStepBefore = oneStepBefore
        oneStepBefore = allWays
    }
    return allWays*/


}

fun main(){
    //test our code

    //N1
    println("isPalindrome: ${isPalindrome("5411145")}\n***")

    //N2
    println("miSplit: ${minSplit(5899)}\n***")

    //N3
    var arr= arrayOf(1,2,3,300,123,123,45,3,4)
    println("notContains:${notContains(arr)}\n***")

    //N4
    println("isProperly: ${isProperly("((()))")}\n***")

    //5
    println("countVariants: ${countVariants(4)}\n***")



//6
    println("******Testing linked list*******\n")
    val list = LinkedList<Int>()
    list.append(3)
    list.push(143)
    list.push(23)
    list.push(13)
    list.append(2)
    list.append(9)
    list.push(23)
    list.push(13)
    list.append(11)
    list.push(414)
    list.push(23)
    list.push(13)
    println(list)

    //let's remove an element at index 7
    // it's able to remove an element in O(1)time but finding element at current index requires O(n) time
    val index = 7
    val node = list.findNodeAt(index-1)!!
    val removedValue = list.removeAfter(node)

    println("remove element at index $index")
    println(list)
    println("Removed value: $removedValue")
}