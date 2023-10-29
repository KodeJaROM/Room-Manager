package cinema


fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    var cinemaSeating = Array(rows) { Array(seats) { "S" } }

    println("Cinema:")

    // Print column numbers
    print("  ")
    for (col in 1..seats) {
        print("$col ")
    }
    println()

    for (row in 0 until rows) {
        print("${row + 1} ") // Print row number

        for (seat in 0 until seats) {
            print("${cinemaSeating[row][seat]} ")
        }
        println()
    }

    println("Enter a row number:")
    val selectedRow = readln().toInt() - 1
    println("Enter a seat number in that row:")
    val selectedSeat = readln().toInt() - 1
    cinemaSeating[selectedRow][selectedSeat] = "B"

    var ticketPrice = 0
    if (rows * seats <= 60) {
        ticketPrice = 10
    } else {
        val frontHalf = rows / 2
        val selectedRowPrice = if (selectedRow < frontHalf) 10 else 8
        ticketPrice = selectedRowPrice
    }
    println("Ticket price: $$ticketPrice")

    println("Cinema:")

    // Print column numbers
    print("  ")
    for (col in 1..seats) {
        print("$col ")
    }
    println()
    for (row in 0 until rows) {
        print("${row + 1} ") // Print row number

        for (seat in 0 until seats) {
            print("${cinemaSeating[row][seat]} ")
        }
        println()
    }
}

