package com.example.anhptt.firststepmvvm.extensions

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat


fun Float.Companion.groupThounsandsToString(value: Double, currency: String): String {
    val decimalFormat: DecimalFormat = NumberFormat.getInstance() as DecimalFormat
    val symbols = decimalFormat.decimalFormatSymbols
    symbols.decimalSeparator = '.'
    symbols.groupingSeparator = ','
    decimalFormat.decimalFormatSymbols = symbols
    decimalFormat.minimumFractionDigits = 0
    decimalFormat.maximumFractionDigits = 2
    decimalFormat.roundingMode = RoundingMode.HALF_UP
    return String.format("%.2f", decimalFormat.format(value))
}