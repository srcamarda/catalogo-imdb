package utils;

public class Validator {
    public static boolean fakeCpfValidator(String cpf) {
        return cpf.length() == 4 && cpf.matches("\\d+");
    }

    public static boolean budgetValidator(int budget) {
        return budget >= 0;
    }

    public static boolean nullOrEmpty(String... dataParams) {
        for (String data : dataParams) {
            if (data == null || data.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}