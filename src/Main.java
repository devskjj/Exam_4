public class Main {
    public static void main(String[] args) {
        try {
            Application.runApplication();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка некорректного ввода. Пожалуйста, попробуйте снова.");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
