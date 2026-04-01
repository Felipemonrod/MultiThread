public class DatabaseAccessThread extends Thread {

    private final DatabaseQueryExecutor queryExecutor;
    private final ConnectionManager connectionManager;

    public DatabaseAccessThread(String name, ConnectionManager connectionManager,
                                DatabaseQueryExecutor queryExecutor) {
        super(name);
        this.connectionManager = connectionManager;
        this.queryExecutor = queryExecutor;
    }

    @Override
    public void run() {
        System.out.println(getName() + " solicitando conexão com o banco de dados...");
        connectionManager.conectar();
        System.out.println(getName() + " obteve o manager com connectionId="
                + connectionManager.getConnectionId());
        queryExecutor.executarConsulta(getName());
        connectionManager.desconectar();
    }
}
