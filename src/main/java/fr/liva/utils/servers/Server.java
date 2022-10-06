package fr.liva.utils.servers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Server {

    private final String address;
    private final int port;

}
