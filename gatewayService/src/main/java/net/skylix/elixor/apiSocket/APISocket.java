package net.skylix.elixor.apiSocket;

import net.skylix.elixor.apiSocket.controller.Controller;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;

/**
 * The actual websocket server.
 */
class TrueServer extends WebSocketServer {
    public TrueServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {

    }
}

/**
 * A class used for creating API services with real time interactions.
 */
public class APISocket {
    /**
     * The connected controllers.
     */
    private ArrayList<Controller> controllers;

    /**
     * Create a new realtime API service.
     */
    public APISocket() {
        TrueServer server = new TrueServer(8080);
        server.start();
    }

    /**
     * Adds a controller to the list of connected controllers.
     * @param controller The controller to add.
     * @return The ID of the controller added.
     */
    public Integer connectController(Controller controller) {
        controllers.add(controller);
        return controllers.size() - 1;
    }

    /**
     * Get a specific controller by its ID.
     * @param id The ID of the controller to get.
     * @return The controller with the specified ID.
     */
    public Controller getController(Integer id) {
        return controllers.get(id);
    }

    /**
     * Removes a controller from the list of connected controllers.
     * @param controller The controller to remove.
     */
    public void disconnectController(Controller controller) {
        controllers.remove(controller);
    }
}
