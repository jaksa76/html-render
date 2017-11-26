package me.jaksa.web.htmlrender;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jaksa on 26/11/2017.
 */
public class Html {
    public static String h1(String s) { return "<h1>" + s + "</h1>";}
    public static String table(Stream s) { return "<table>" + join(s) + "</table>"; }
    public static String table(final String... rows) { return "<table>" + String.join("", rows) + "</table>"; }
    public static String tr(final String... cells) { return "<tr>" + String.join("", cells) + "</td>"; }
    public static String tr(final Stream s) { return "<tr>" + join(s) + "</td>"; }
    public static String th(final String s) { return "<th>" + s + "</th>"; }
    public static String td(final String s) { return "<td>" + s + "</td>"; }
    public static String div(final String s) { return "<div>" + s + "</div>"; }
    private static Object join(Stream s) { return s.collect(Collectors.joining()); }
}
