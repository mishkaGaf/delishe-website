package com.delishe;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DelisheWebsite {

    // =============================================================
    // EDIT YOUR BUSINESS INFORMATION HERE
    // =============================================================
    private static final String BUSINESS_NAME = "Delishe";
    private static final String TAGLINE = "Made With Love, tasted to perfection!";
    private static final String INTRO = "Homemade food for celebrations, families and special moments.";
    private static final String ABOUT = "Delishe is a small food business built around care, flavour and the joy of sharing homemade food.";
    private static final String PHONE_DISPLAY = "063 497 7581";
    private static final String WHATSAPP_NUMBER = "27634977581";
    private static final String EMAIL = "delishe2026@gmail.com";
    private static final String LOCATION = "Durban";
    private static final String HOURS = "Monday–Friday: 09:00–16:00 | Saturday: 10:00–13:00";

    public static void main(String[] args) throws IOException {
        String portValue = System.getenv("PORT");

        int port;

        if (portValue == null) {
             port = 8080; // Used in NetBeans
    } else {
             port = Integer.parseInt(portValue); // Used online
    }

    HttpServer server = HttpServer.create(
        new InetSocketAddress(port), 0
    );
        server.createContext("/", DelisheWebsite::showHomePage);
        server.createContext("/logo.png", DelisheWebsite::showLogo);
        server.setExecutor(null);
        server.start();

        System.out.println("Delishe website is running.");
        System.out.println("Open http://localhost:8080 in your browser.");
        System.out.println("Stop it with the red Stop button in NetBeans.");
    }

    private static void showHomePage(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestURI().getPath().equals("/")) {
            sendText(exchange, 404, "Page not found", "text/plain; charset=UTF-8");
            return;
        }

        String orderMessage = URLEncoder.encode(
                "Hello Delishe, I would like to place an order.", StandardCharsets.UTF_8);

        String products = """
                %s
                %s=
                %s
                """.formatted(
                product("Signature Cakes", "Cakes for birthdays and celebrations.", "From R350"),
                product("Sweet Treats", "Homemade desserts for gifting and sharing.", "From R100"),
                product("Savoury Platters", "Fresh platters for gatherings and events.", "Ask for a quote")
        );

        String html = """
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>%s | Made With Love</title>
                    <style>
                        :root { --wine:#710019; --gold:#efbd4b; --cream:#fff8e9; --ink:#241418; }
                        * { box-sizing:border-box; }
                        html { scroll-behavior:smooth; }
                        body { margin:0; font-family:Arial,sans-serif; color:var(--ink); background:var(--cream); line-height:1.6; }
                        header { display:flex; justify-content:space-between; align-items:center; padding:18px 6%%; background:white; position:sticky; top:0; }
                        header strong { color:var(--wine); font-size:1.3rem; letter-spacing:.12em; }
                        nav { display:flex; flex-wrap:wrap; gap:18px; }
                        nav a { color:var(--wine); text-decoration:none; font-weight:bold; }
                        section { padding:80px 6%%; }
                        h1,h2,h3 { line-height:1.15; }
                        h1 { color:var(--wine); font-family:Georgia,serif; font-size:clamp(2.8rem,7vw,6rem); margin:12px 0; }
                        h2 { color:var(--wine); font-family:Georgia,serif; font-size:clamp(2rem,4vw,3.5rem); }
                        .hero { min-height:78vh; display:grid; grid-template-columns:1.1fr .9fr; align-items:center; gap:7%%; }
                        .hero img { width:100%%; max-width:480px; border-radius:50%%; box-shadow:0 25px 60px #71001933; }
                        .eyebrow { color:var(--wine); text-transform:uppercase; letter-spacing:.15em; font-weight:bold; font-size:.78rem; }
                        .button { display:inline-block; margin-top:14px; padding:13px 22px; color:white; background:var(--wine); border-radius:40px; text-decoration:none; font-weight:bold; }
                        .menu-grid { display:grid; grid-template-columns:repeat(3,1fr); gap:18px; }
                        .product { padding:25px; background:white; border-radius:18px; border:1px solid #71001922; }
                        .price { display:block; margin-top:15px; color:var(--wine); font-weight:bold; }
                        .about { background:white; }
                        .about p { max-width:700px; }
                        .contact { text-align:center; color:white; background:var(--wine); }
                        .contact h2 { color:var(--gold); }
                        .contact a { color:var(--gold); }
                        .contact .button { background:var(--gold); color:var(--wine); }
                        footer { padding:22px; text-align:center; }
                        @media (max-width:750px) {
                            header { flex-direction:column; gap:10px; }
                            .hero { grid-template-columns:1fr; text-align:center; }
                            .hero img { max-width:330px; justify-self:center; }
                            .menu-grid { grid-template-columns:1fr; }
                            section { padding:60px 6%%; }
                        }
                    </style>
                </head>
                <body>
                    <header>
                        <strong>%s</strong>
                        <nav><a href="#home">Home</a><a href="#menu">Menu</a><a href="#about">About</a><a href="#contact">Contact</a></nav>
                    </header>
                    <main>
                        <section class="hero" id="home">
                            <div><p class="eyebrow">Freshly prepared</p><h1>%s</h1><p>%s</p><a class="button" href="#menu">View our menu</a></div>
                            <img src="/logo.png" alt="Delishe logo">
                        </section>
                        <section id="menu"><p class="eyebrow">A little taste</p><h2>Our Menu</h2><div class="menu-grid">%s</div></section>
                        <section class="about" id="about"><p class="eyebrow">Our story</p><h2>About %s</h2><p>%s</p></section>
                        <section class="contact" id="contact"><h2>Place an Order</h2><p>Phone: %s<br>Email: <a href="mailto:%s">%s</a><br>Location: %s<br>Hours: %s</p><a class="button" href="https://wa.me/%s?text=%s">Order on WhatsApp</a></section>
                    </main>
                    <footer>© 2026 %s — %s</footer>
                </body>
                </html>
                """.formatted(
                BUSINESS_NAME, BUSINESS_NAME, TAGLINE, INTRO, products,
                BUSINESS_NAME, ABOUT, PHONE_DISPLAY, EMAIL, EMAIL, LOCATION,
                HOURS, WHATSAPP_NUMBER, orderMessage, BUSINESS_NAME, TAGLINE
        );

        sendText(exchange, 200, html, "text/html; charset=UTF-8");
    }

    // Copy this method call in showHomePage() to add another menu item.
    private static String product(String name, String description, String price) {
        return """
                <article class="product">
                    <h3>%s</h3>
                    <p>%s</p>
                    <span class="price">%s</span>
                </article>
                """.formatted(name, description, price);
    }

    private static void showLogo(HttpExchange exchange) throws IOException {
        try (InputStream input = DelisheWebsite.class.getResourceAsStream("/logo.png")) {
            if (input == null) {
                sendText(exchange, 404, "Logo not found", "text/plain; charset=UTF-8");
                return;
            }
            byte[] image = input.readAllBytes();
            exchange.getResponseHeaders().set("Content-Type", "image/png");
            exchange.sendResponseHeaders(200, image.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(image);
            }
        }
    }

    private static void sendText(HttpExchange exchange, int status, String text, String contentType)
            throws IOException {
        byte[] response = text.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(status, response.length);
        try (OutputStream output = exchange.getResponseBody()) {
            output.write(response);
        }
    }
}
