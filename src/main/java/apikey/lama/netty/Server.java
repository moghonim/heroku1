package apikey.lama.netty;


//@SpringBootApplication
public class Server {
//    private static final Logger log = LogManager.getLogger(Server.class);
//    public static final String HOST = "localhost";
//    public static final int PORT = 8080;
//
//    public static void main(String[] args) throws Exception {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CorsConfiguration.class);
//        Server server = new Server();
//        server.startReactorServer(ctx);
//
//        System.out.println("Press ENTER to exit.");
//        System.in.read();
//    }
//
////    @Autowired
////    CustomUserRepository repository ;
//    @Autowired
//    PersonHandler handler ;
//    public RouterFunction<ServerResponse> routingFunction() {
//
//
//        return nest(path("/test"),
//                nest(accept(APPLICATION_JSON),
//                        route(GET("/{param}"), handler::listPeople)
//                                .andRoute(method(HttpMethod.GET), handler::listPeople)
//                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::createPerson));
//    }
//
//    private <T extends ServerResponse> RouterFunction<T> route(RequestPredicate get, Object listPeople) {
//    }
//
//    public void startReactorServer(AnnotationConfigApplicationContext ctx) {
//        RouterFunction<ServerResponse> route = this.routingFunction().filter((request, next) -> {
//            log.warn(request.path());
//
//            if (request.path().contains("person")) {
//                log.warn("calling next()");
//                return next.handle(request);
//            } else {
//                return ServerResponse.status(UNAUTHORIZED).build();
//            }
//        });
//
//        HttpHandler httpHandler = WebHttpHandlerBuilder.webHandler(RouterFunctions.toWebHandler(route))
//                .applicationContext(ctx).build();
//
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
//        HttpServer server = HttpServer.create(HOST, PORT);
//        server.newHandler(adapter).block();
//    }
}
