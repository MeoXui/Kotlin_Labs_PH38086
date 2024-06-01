package fpoly.huynkph38086.kotlin_labs.lab2

class lab2 {
    companion object {
        fun bai1() {
            val a: Double
            val b: Double

            println("Giải phương chình ax + b = 0:")
            println("Nhập dữ liệu...")

            print("a = ")
            var s = readlnOrNull()
            a = try {
                s!!.toDouble()
            } catch (e: Exception) {
                0.0
            }

            print("b = ")
            s = readlnOrNull()
            b = try {
                s!!.toDouble()
            } catch (e: Exception) {
                0.0
            }

            if(a == 0.0) {
                if (b == 0.0) println("Phương trình vô số nghiệm.")
                else println("Phương trình vô nghiệm.")

            } else println("Phương trình có nghiệm: x = " + (-b/a))
        }

        fun bai2() {
            val month: Int
            print("Nhập tháng: ")
            val s = readlnOrNull()
            month = s!!.toInt()
            when (month) {
                1, 2, 3 -> println("Tháng $month thuộc quý 1")
                4, 5, 6 -> println("Tháng $month thuộc quý 2")
                7, 8, 9 -> println("Tháng $month thuộc quý 3")
                10, 11, 12 -> println("Tháng $month thuộc quý 4")
                else -> println("Tháng $month không hợp lệ")
            }
        }

        fun bai3() {
            var y: Int
            print("Nhập năm: ")
            var s = readlnOrNull()
            y = s!!.toInt()
            if (y < 0) {
                println("Năm không hợp lệ. Mời nhập lại.")
                bai3()
                return
            }

            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
                println("Năm $y là năm nhuận")
            else println("Năm $y không phải năm nhuận")

            print("Tiếp không?(c/k): ")
            s = readlnOrNull()
            if (s == "c") bai3()
        }

        fun bai4(a: Int, b: Int): Int {
            var ucln = if (b < a) b else a

            for (i in ucln downTo 1)
                if (a % i == 0 && b % i == 0)
                    return i
            return 1
        }
    }
}