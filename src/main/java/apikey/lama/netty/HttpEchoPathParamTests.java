package apikey.lama.netty;


import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Learn how to create HTTP server and client
 *
 * @author Violeta Georgieva
 * @see <a href="https://projectreactor.io/docs/netty/release/api/reactor/netty/http/server/HttpServer.html">HttpServer javadoc</a>
 * @see <a href="https://projectreactor.io/docs/netty/release/api/reactor/netty/http/client/HttpClient.html">HttpClient javadoc</a>
 */

//@SpringBootApplication
public class HttpEchoPathParamTests {

//    @Test

//    @Bean
    public void echoPathParamTest() {
        DisposableServer server =
                HttpServer.create()   // Prepares an HTTP server for configuration.
                        .port(8081)    // Configures the port number as zero, this will let the system pick up
                        // an ephemeral port when binding the server.
                        .route(routes ->
                                // The server will respond only on POST requests
                                // where the path starts with /test and then there is path parameter
                                routes.get("/test/{param}", (req, res) ->
                                        res.sendString(req.receive()
                                                .asString()
                                                .map(s -> s + ' ' + req.param("param") + '!')
                                                .log("http-server"))))
                        .wiretap(true)  // Applies a wire logger configuration.
                        .bindNow(); // Starts the server in a blocking fashion, and waits for it to finish initializing.

        assertNotNull(server);

//        String response =
//                HttpClient.create()             // Prepares an HTTP client for configuration.
//                        .port(8081)  // Obtains the server's port and provides it as a port to which this
//                        // client should connect.
//                        .wiretap(true)        // Applies a wire logger configuration.
//                        .headers(h -> h.add("Content-Type", "text/plain")) // Adds headers to the HTTP request
//                        .get()              // Specifies that POST method will be used
//                        .uri("/test/World")  // Specifies the path
////                        .send(ByteBufMono.fromString(Mono.just("Hello")))  // Sends the request body
//                        .responseContent()   // Receives the response body
//                        .aggregate()
//                        .asString()
//                        .log("http-client")
//                        .block();
//
//        assertEquals("Hello World!", response);

//        server.disposeNow();          // Stops the server and releases the resources.
    }
}