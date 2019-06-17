public class IO {
    IO(Client client) {
        this.client = client;
    }
    public void invalidMoveIO() {
        client.write("Invalid move!");
    }

    public String selectAMoveIO() {
        return "Please select a number between 1 - 9: ";
    }
}
