public class TestConnection {
    public static void main(String[] args) {
        try {
            var conn = DatabaseConnection.getConnection();
            System.out.println("Conectou com sucesso!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
