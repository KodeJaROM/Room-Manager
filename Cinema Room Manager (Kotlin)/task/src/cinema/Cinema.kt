package cinema


fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    var income = 0

    if (rows * seats <= 60) {
        income = (rows * seats) * 10
    } else {
        if (rows % 2 == 0) {
            income = ((rows / 2) * seats * 10) + ((rows / 2) * seats * 8)
        } else {
            income = ((rows / 2) * seats * 10) + ((rows % 2 + rows / 2) * seats * 8)
        }
    }

    println("Total income:")
    println("$$income")
}
