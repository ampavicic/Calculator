package lecture4.ruazosa.fer.hr.calculator

object Calculator {

    var result: Double = 0.0
    private set

    var expression: MutableList<String> = mutableListOf()
    private set

    var expressionNormal: MutableList<String> = mutableListOf()
    private set

    fun reset() {
        result = 0.0
        expression = mutableListOf()
        expressionNormal = mutableListOf()
    }

    fun addNumber(number: String) {
        try {
            val num = number.toDouble()
        } catch (e: NumberFormatException) {
            throw Exception("Not valid number")
        }

        if (expression.count()%2 == 0) {
            expression.add(number)
        }
        else {
            throw Exception("Not a valid order of numbers in expression")
        }
    }

    fun addOperator(operator: String) {
        if (expression.count()%2 != 1)  {
            throw Exception("Not a valid order of operator in expression")
        }
        when (operator) {
            "+" -> expression.add(operator)
            "-" -> expression.add(operator)
            "x" -> expression.add(operator)
            "%" -> expression.add(operator)
            else -> {
                throw Exception("Not a valid operator")
            }
        }
    }

    /*fun evaluate() {

        if (expression.count() % 2 == 0) {
            throw Exception("Not a valid expression")
        }

        result = expression[0].toDouble()

        for(i in 1..expression.count()- 1 step 2) {
            when(expression[i]) {
                "x" -> result = result * expression[i+1].toDouble()
                "%" -> result = result / expression[i+1].toDouble()
                "+" -> result = result + expression[i+1].toDouble()
                "-" -> result = result - expression[i+1].toDouble()
            }
        }
    }*/
    /*fun evaluate() { //zašto mi neda da kopiram listu i onda nju upotrebljavam

        if (expression.count() % 2 == 0) {
            throw Exception("Not a valid expression")
        }

        for(i in 0..expression.count()) {
            if (expression[i] != "x" && expression[i] != "%" // ako ti nisi puta ili dijeljenje
                    && expression[i+1] != "x" && expression[i+1] != "%" //ako sljedeći nije
                    && expression[i-1] != "x" && expression[i-1] != "%") //ako prošli nije bio
                    {
                expressionNormal.add(expression[i])
            }
            else {
                if (expression[i] == "x") expressionNormal.add((expression[i-1].toDouble()* expression[i+1].toDouble()).toString())
                if (expression[i] == "%") expressionNormal.add((expression[i-1].toDouble()/ expression[i+1].toDouble()).toString())
            }
        }
        result = expressionNormal[0].toDouble()
        for(i in 1..expressionNormal.count()- 1 step 2) {
            when(expressionNormal[i]) {
                "+" -> result = result + expressionNormal[i+1].toDouble()
                "-" -> result = result - expressionNormal[i+1].toDouble()
            }
        }
    }*/
    /*fun evaluate() {

        if (expression.count() % 2 == 0) {
            throw Exception("Not a valid expression")
        }

        for(i in 0..expression.count()) {
            expressionNormal.add(expression[i])
        }
        result = expressionNormal[0].toDouble()
        for(i in 1..expressionNormal.count()- 1 step 2) {
            when(expressionNormal[i]) {
                "+" -> result = result + expressionNormal[i+1].toDouble()
                "-" -> result = result - expressionNormal[i+1].toDouble()
            }
        }
    }*/
    fun evaluate() {

        if (expression.count() % 2 == 0) {
            throw Exception("Not a valid expression")
        }

        result = expression[0].toDouble()

        for(i in 1..expression.count()- 1 step 2) {
            when(expression[i]) {
                "x" ->  {
                    if (i < 2) result = result * expression[i+1].toDouble()
                    else {
                        when (expression[i - 2]) {
                            "-" -> result = result + expression[i + 1].toDouble() - expression[i - 1].toDouble() * expression[i + 1].toDouble()
                            "+" -> result = result - expression[i + 1].toDouble() + expression[i - 1].toDouble() * expression[i + 1].toDouble()
                            "%" -> result = result * expression[i + 1].toDouble()
                            "x" -> result = result * expression[i + 1].toDouble()
                        }
                    }
                }
                "%" -> {
                    if (i < 2) result = result / expression[i+1].toDouble()
                    else {
                    when(expression[i-2]) {
                        "-" -> result = result + expression[i+1].toDouble() - expression[i-1].toDouble() / expression[i+1].toDouble()
                        "+" -> result = result - expression[i+1].toDouble() + expression[i-1].toDouble() / expression[i+1].toDouble()
                        "%" -> result = result / expression[i+1].toDouble()
                        "x" -> result = result / expression[i+1].toDouble()
                    }
                    }
                }
                "+" -> result = result + expression[i+1].toDouble()
                "-" -> result = result - expression[i+1].toDouble()
            }
        }
    }
}