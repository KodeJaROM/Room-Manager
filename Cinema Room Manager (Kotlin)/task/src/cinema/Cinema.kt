package cinema


fun main() {
    //    Initializing an array to show the seating arrangement, based on user input
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    var cinemaSeating = Array(rows) { Array(seats) { "S" } }

    //    function to print the seating arrangement
    fun printCinemaSeating() {
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

    fun buyTicket() {
        println("Enter a row number:")
        val selectedRow = readln().toInt() - 1
        println("Enter a seat number in that row:")
        val selectedSeat = readln().toInt() - 1
        cinemaSeating[selectedRow][selectedSeat] = "B"

        val ticketPrice: Int = if (rows * seats <= 60) {
            10
        } else {
            val frontHalf = rows / 2
            val selectedRowPrice = if (selectedRow < frontHalf) 10 else 8
            selectedRowPrice
        }
        println("Ticket price: $$ticketPrice")
    }

//    getting user input based on a menu
    while (true) {
        println(
            """
            1. Show the seats
            2. Buy a ticket
            0. Exit
            """.trimIndent()
        )
        when (readln().toInt()) {
            0 -> break
            1 -> printCinemaSeating()
            2 -> buyTicket()
        }
    }
}



