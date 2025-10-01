package chatapp;

import java.util.*;

// ---------- Adapter for communication ----------
interface CommAdapter {
    void send(String sender, String message);
}

class WebSocketComm implements CommAdapter {
    @Override
    public void send(String sender, String message) {
        System.out.println("[" + sender + "]: " + message);
    }
}

// ---------- Observer for users ----------
interface Observer {
    void notify(String sender, String message);
}

class User implements Observer {
    private final String username;
    private final CommAdapter comm;

    public User(String username, CommAdapter comm) {
        this.username = username;
        this.comm = comm;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void notify(String sender, String message) {
        comm.send(sender, message);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && username.equals(((User) obj).username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}

// ---------- ChatRoom to manage users and messages ----------
class ChatRoom {
    private final String roomId;
    private final List<User> users = new ArrayList<>();
    private final List<String> messageHistory = new ArrayList<>();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

    public void join(User user) {
        if (!users.contains(user)) {
            users.add(user);
            String joinMsg = "[System]: " + user.getUsername() + " has joined the room.";
            messageHistory.add(joinMsg);
            System.out.println(joinMsg);
        }
    }

    public void sendMessage(User user, String message) {
        String formattedMsg = "[" + user.getUsername() + "]: " + message;
        messageHistory.add(formattedMsg);
        user.notify(user.getUsername(), message);
    }

    public List<String> getActiveUsers() {
        List<String> names = new ArrayList<>();
        for (User u : users) names.add(u.getUsername());
        return names;
    }

    public List<String> getMessageHistory() {
        return new ArrayList<>(messageHistory);
    }
}

// ---------- Singleton manager for chat rooms ----------
class ChatManager {
    private static final ChatManager instance = new ChatManager();
    private final Map<String, ChatRoom> rooms = new HashMap<>();

    private ChatManager() {}

    public static ChatManager getInstance() {
        return instance;
    }

    public ChatRoom getOrCreateRoom(String roomId) {
        return rooms.computeIfAbsent(roomId, ChatRoom::new);
    }
}

// ---------- Main Application ----------
public class ChatApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatManager manager = ChatManager.getInstance();

        System.out.print("Enter Chat Room ID to join or create: ");
        String roomId = scanner.nextLine();
        ChatRoom room = manager.getOrCreateRoom(roomId);

        System.out.print("Enter number of users: ");
        int numUsers = Integer.parseInt(scanner.nextLine());

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= numUsers; i++) {
            System.out.print("Enter username for User " + i + ": ");
            String name = scanner.nextLine();
            User user = new User(name, new WebSocketComm());
            users.add(user);
            room.join(user);
        }

        System.out.println("\nActive Users: " + room.getActiveUsers());

        System.out.println("\nEnter messages for each user:");
        for (User user : users) {
            System.out.print("Message from " + user.getUsername() + ": ");
            String msg = scanner.nextLine();
            room.sendMessage(user, msg); // send each message once
        }

        System.out.println("\n=== Message History ===");
        for (String msg : room.getMessageHistory()) {
            System.out.println(msg);
        }

        System.out.println("\nActive Users: " + room.getActiveUsers());
        scanner.close();
    }
}
