public class App {
    public static void main(String[] args) {
        System.out.println("=== Simulação de Acesso ao Banco de Dados com Múltiplas Threads ===\n");

        ConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        DatabaseQueryExecutor queryExecutor = new DatabaseQueryExecutor(connectionManager);

        int numThreads = 5;
        DatabaseAccessThread[] threads = new DatabaseAccessThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new DatabaseAccessThread("Thread-DB-" + (i + 1),
                    connectionManager, queryExecutor);
        }

        for (DatabaseAccessThread thread : threads) {
            thread.start();
        }

        for (DatabaseAccessThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n=== Todas as threads finalizaram ===");
    }
}
