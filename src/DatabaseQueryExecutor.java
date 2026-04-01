public class DatabaseQueryExecutor {

    private final ConnectionManager connectionManager;

    public DatabaseQueryExecutor(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public synchronized void executarConsulta(String threadName) {
        int connId = connectionManager.getConnectionId();
        System.out.println("[Conexão " + connId + "] " + threadName
                + " iniciou consulta ao banco de dados...");
        try {
            Thread.sleep((long) (Math.random() * 2000 + 500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[Conexão " + connId + "] " + threadName
                + " finalizou consulta ao banco de dados.");
    }
}
