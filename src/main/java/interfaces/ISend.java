package interfaces;

import computer.Client;
import computer.Letter;

public interface ISend {
    void send(Letter letter, Client firstClient, Client secondClient);
}
