package cinema


fun main() {
    //    Initializing an array to show the seating arrangement, based on user input. Initializing variables to store information about tickets
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    var cinemaSeating = Array(rows) { Array(seats) { "S" } }
    var totalSeats = rows * seats
    var purchasedTickets = 0
    var currentIncome = 0
    var maxIncome: Int = if (rows * seats <= 60) {
        rows * seats * 10
    } else {
        val frontHalf = rows / 2
        val backHalf = rows - frontHalf
        (frontHalf * seats * 10) + (backHalf * seats * 8)
    }

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
        try {
            if (cinemaSeating[selectedRow][selectedSeat] == "B") {
                println("That ticket has already been purchased!\n")
                buyTicket()
            } else {
                cinemaSeating[selectedRow][selectedSeat] = "B"
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("Wrong Input!\n")
            buyTicket()
        }

        val ticketPrice: Int = if (rows * seats <= 60) {
            10
        } else {
            val frontHalf = rows / 2
            val selectedRowPrice = if (selectedRow < frontHalf) 10 else 8
            selectedRowPrice
        }
        purchasedTickets += 1
        currentIncome += ticketPrice
        println("Ticket price: $$ticketPrice\n")
    }

    //    Prints the number of purchased tickets, percentage of purchased tickets, current income, total of all seats in theatre
    fun showStatistics() {
        println("Number of purchased tickets: $purchasedTickets")
        println("Percentage: ${"%.2f".format((100.00 * purchasedTickets.toDouble()) / totalSeats.toDouble())}%")
        println("Current income: $$currentIncome")
        println("Total income: $$maxIncome\n")
    }

//    getting user input based on a menu
    while (true) {
        println(
            """
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
            """.trimIndent()
        )
        when (readln().toInt()) {
            0 -> break
            1 -> printCinemaSeating()
            2 -> buyTicket()
            3 -> showStatistics()
            else -> println("Wrong Input!\n")
        }
    }
}





