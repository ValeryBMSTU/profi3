package org.example.service;

import org.example.service.webserver.Options;
import org.example.service.webserver.Server;

/**
 * Стартовый класс, с которого все запускается
 */
public class Main {
    public static void main(String[] args)  {
        Options webOpts = new Options("./www");
        Server.start(webOpts, new WebInterface());
        System.out.println("Server started");
    }
}
