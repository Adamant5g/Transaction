fun main() {
    val cardType =  "Visa"
    val monthlyTransfer = 500
    val transfer = 50_000

    val commission = commissionCalculation(cardType = cardType, transfer = transfer, monthlyTransfer = monthlyTransfer)
    println ("Коммиссия при переводе с карты: $cardType, составит: $commission")

}

fun commissionCalculation(cardType: String = "VK Pay", monthlyTransfer: Int = 0, transfer: Int) : Int {
    val freeLimit = 75_000
    val transactionAmount = monthlyTransfer + transfer
    val commissionForMastercardMaestro = 0.006
    val minCommissionForMastercardMaestro = 20
    val commissionForVisaMir = 0.0075
    val minCommissionForVisaMir = 35
    val finalСommissionForVisaMir = transactionAmount * commissionForVisaMir

    return when(cardType) {
        "Mastercard", "Maestro" -> if (transactionAmount > freeLimit) ((transactionAmount * commissionForMastercardMaestro) + minCommissionForMastercardMaestro).toInt() else 0
        "Visa", "Мир" -> if (finalСommissionForVisaMir > minCommissionForVisaMir) finalСommissionForVisaMir.toInt() else minCommissionForVisaMir
        else -> 0
    }
}