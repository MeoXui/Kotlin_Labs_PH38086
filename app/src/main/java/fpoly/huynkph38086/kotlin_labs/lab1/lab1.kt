package fpoly.huynkph38086.kotlin_labs.lab1

import kotlin.math.sqrt

class lab1{
    companion object {
         fun A1B0 (a: Double, b: Double): String {
            if (a == 0.0) {
                return if (b == 0.0) "Phương trình có vô số nghiệm."
                else "Pương trình vô nghiệm."
            }
            return "Phương trình có nghiệm x = " + (-b/a)
        }

        fun A2B1C0 (a: Double, b: Double, c: Double): String {
            if (a == 0.0) return A1B0(b, c)
            val delta = b*b - 4*a*c
            var x1 = 0.0
            var x2 = -b / (2 * a)
            if (delta == 0.0) x1 = x2
            if (delta > 0.0) {
                x1 = (-b + sqrt(delta)) / (2 * a)
                x2 = (-b - sqrt(delta)) / (2 * a)
            }

            if (delta < 0.0) return "Phương trình có nghiệm phức."
            if (x1 == x2) return "Phương trình có nghiệm kép x = $x1"
            return "Phương trình có 2 nghiệm:\nx1 = $x1\nx2 = $x2"
        }
    }
}