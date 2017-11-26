package me.jaksa.web.htmlrender;

import java.util.Collection;

import static me.jaksa.web.htmlrender.ClassUtils.*;
import static me.jaksa.web.htmlrender.Html.*;

public class Render {
    public String asCard(Object obj) {
        if (obj == null) return "";

        Class<?> cls = obj.getClass();
//        System.out.println(cls);
        if (isSimple(cls)) return obj.toString();

        if (isCollection(cls))
            return table(((Collection) obj).stream().map(element -> tr(td(asCard(element)))));

        return table(getFields(obj).map(f -> tr(td(f.getName()), td(asCard(getValue(obj, f))))));
    }

    public <T> String asTable(Collection<T> objects, Class<T> cls) {
        StringBuilder s = new StringBuilder();
        s.append(tr(getFields(cls).map(f -> th(f.getName()))));
        for (T object : objects) {
            s.append(tr(getFields(cls).map(f -> td(asCard(getValue(object, f))))));
        }
        return table(s.toString());
    }
}
