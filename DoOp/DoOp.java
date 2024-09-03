public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "Error";
        }

        try {
            // Convertir les opérandes en entiers
            int leftOperand = Integer.parseInt(args[0]);
            int rightOperand = Integer.parseInt(args[2]);
            String operator = args[1];

            // Effectuer l'opération en fonction de l'opérateur
            switch (operator) {
                case "+":
                    return String.valueOf(leftOperand + rightOperand);
                case "-":
                    return String.valueOf(leftOperand - rightOperand);
                case "*":
                    return String.valueOf(leftOperand * rightOperand);
                case "/":
                    if (rightOperand == 0) {
                        return "Error"; // Division par zéro
                    }
                    return String.valueOf(leftOperand / rightOperand);
                case "%":
                    if (rightOperand == 0) {
                        return "Error"; // Division par zéro
                    }
                    return String.valueOf(leftOperand % rightOperand);
                default:
                    return "Error"; // Opérateur inconnu
            }
        } catch (NumberFormatException e) {
            return "Error"; // Erreur de format des nombres
        }
    }
}
