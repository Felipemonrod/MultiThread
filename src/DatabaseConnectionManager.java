public class DatabaseConnectionManager implements ConnectionManager {

    private static volatile DatabaseConnectionManager instance;
    private final int connectionId;

    private DatabaseConnectionManager() {
        this.connectionId = (int) (Math.random() * 10000);
        System.out.println("[Manager] Instância criada com connectionId=" + connectionId
                + " pela thread " + Thread.currentThread().getName());
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    @Override
    public int getConnectionId() {
        return connectionId;
    }

    @Override
    public void conectar() {
        System.out.println("[Conexão " + connectionId + "] Conexão estabelecida.");
    }

    @Override
    public void desconectar() {
        System.out.println("[Conexão " + connectionId + "] Conexão encerrada.");
    }
}
