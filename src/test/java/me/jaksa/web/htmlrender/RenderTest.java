package me.jaksa.web.htmlrender;

import spark.Spark;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static me.jaksa.web.htmlrender.Html.h1;

public class RenderTest {
    public static void main(String... args) throws Exception {

        Spark.get("/", (req, resp) -> generateHtml());

        Desktop.getDesktop().browse(new URI("http://localhost:4567"));
    }

    private static String generateHtml() {
        Render render = new Render();

        String html = "";
        html += h1("null") + render.asCard(null);
        html += h1("int") + render.asCard(1);
        html += h1("Float") + render.asCard(new Float(1.0));
        html += h1("String") + render.asCard("Hello World!");
        html += h1("Class with private fields") + render.asCard(new Phone("+382 69 123456", "mobile"));
        html += h1("Complex class") + render.asCard(new Person("Jaksa", "Vuckovic", asList(new Phone("+44 123", "mob"), new Phone("+44 456", "fax"))));

        html += h1("Table of classes") + render.asTable(generatePeople(), Person.class);
        return html;
    }

    private static Collection<Person> generatePeople() {
        return asList(
                new Person("John", "Doe", asList(new Phone("+44 123", "mob"), new Phone("+44 456", "fax"))),
                new Person("Jane", "Doe", asList(new Phone("+44 222", "mob"), new Phone("+44 333", "fax"))),
                new Person("Alice", "Doe", asList(new Phone("+44 444", "mob"), new Phone("+44 555", "fax")))
        );
    }
}