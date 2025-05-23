package snowball;

import java.io.Serial;

public class spanishStemmer extends SnowballStemmer {

    @Serial
    private static final long serialVersionUID = 1L;

private final static Among[] a_0 = {
    new Among("", -1, 6),
    new Among("\u00E1", 0, 1),
    new Among("\u00E9", 0, 2),
    new Among("\u00ED", 0, 3),
    new Among("\u00F3", 0, 4),
    new Among("\u00FA", 0, 5)
};

private final static Among[] a_1 = {
    new Among("la", -1, -1),
    new Among("sela", 0, -1),
    new Among("le", -1, -1),
    new Among("me", -1, -1),
    new Among("se", -1, -1),
    new Among("lo", -1, -1),
    new Among("selo", 5, -1),
    new Among("las", -1, -1),
    new Among("selas", 7, -1),
    new Among("les", -1, -1),
    new Among("los", -1, -1),
    new Among("selos", 10, -1),
    new Among("nos", -1, -1)
};

private final static Among[] a_2 = {
    new Among("ando", -1, 6),
    new Among("iendo", -1, 6),
    new Among("yendo", -1, 7),
    new Among("\u00E1ndo", -1, 2),
    new Among("i\u00E9ndo", -1, 1),
    new Among("ar", -1, 6),
    new Among("er", -1, 6),
    new Among("ir", -1, 6),
    new Among("\u00E1r", -1, 3),
    new Among("\u00E9r", -1, 4),
    new Among("\u00EDr", -1, 5)
};

private final static Among[] a_3 = {
    new Among("ic", -1, -1),
    new Among("ad", -1, -1),
    new Among("os", -1, -1),
    new Among("iv", -1, 1)
};

private final static Among[] a_4 = {
    new Among("able", -1, 1),
    new Among("ible", -1, 1),
    new Among("ante", -1, 1)
};

private final static Among[] a_5 = {
    new Among("ic", -1, 1),
    new Among("abil", -1, 1),
    new Among("iv", -1, 1)
};

private final static Among[] a_6 = {
    new Among("ica", -1, 1),
    new Among("ancia", -1, 2),
    new Among("encia", -1, 5),
    new Among("adora", -1, 2),
    new Among("osa", -1, 1),
    new Among("ista", -1, 1),
    new Among("iva", -1, 9),
    new Among("anza", -1, 1),
    new Among("log\u00EDa", -1, 3),
    new Among("idad", -1, 8),
    new Among("able", -1, 1),
    new Among("ible", -1, 1),
    new Among("ante", -1, 2),
    new Among("mente", -1, 7),
    new Among("amente", 13, 6),
    new Among("aci\u00F3n", -1, 2),
    new Among("uci\u00F3n", -1, 4),
    new Among("ico", -1, 1),
    new Among("ismo", -1, 1),
    new Among("oso", -1, 1),
    new Among("amiento", -1, 1),
    new Among("imiento", -1, 1),
    new Among("ivo", -1, 9),
    new Among("ador", -1, 2),
    new Among("icas", -1, 1),
    new Among("ancias", -1, 2),
    new Among("encias", -1, 5),
    new Among("adoras", -1, 2),
    new Among("osas", -1, 1),
    new Among("istas", -1, 1),
    new Among("ivas", -1, 9),
    new Among("anzas", -1, 1),
    new Among("log\u00EDas", -1, 3),
    new Among("idades", -1, 8),
    new Among("ables", -1, 1),
    new Among("ibles", -1, 1),
    new Among("aciones", -1, 2),
    new Among("uciones", -1, 4),
    new Among("adores", -1, 2),
    new Among("antes", -1, 2),
    new Among("icos", -1, 1),
    new Among("ismos", -1, 1),
    new Among("osos", -1, 1),
    new Among("amientos", -1, 1),
    new Among("imientos", -1, 1),
    new Among("ivos", -1, 9)
};

private final static Among[] a_7 = {
    new Among("ya", -1, 1),
    new Among("ye", -1, 1),
    new Among("yan", -1, 1),
    new Among("yen", -1, 1),
    new Among("yeron", -1, 1),
    new Among("yendo", -1, 1),
    new Among("yo", -1, 1),
    new Among("yas", -1, 1),
    new Among("yes", -1, 1),
    new Among("yais", -1, 1),
    new Among("yamos", -1, 1),
    new Among("y\u00F3", -1, 1)
};

private final static Among[] a_8 = {
    new Among("aba", -1, 2),
    new Among("ada", -1, 2),
    new Among("ida", -1, 2),
    new Among("ara", -1, 2),
    new Among("iera", -1, 2),
    new Among("\u00EDa", -1, 2),
    new Among("ar\u00EDa", 5, 2),
    new Among("er\u00EDa", 5, 2),
    new Among("ir\u00EDa", 5, 2),
    new Among("ad", -1, 2),
    new Among("ed", -1, 2),
    new Among("id", -1, 2),
    new Among("ase", -1, 2),
    new Among("iese", -1, 2),
    new Among("aste", -1, 2),
    new Among("iste", -1, 2),
    new Among("an", -1, 2),
    new Among("aban", 16, 2),
    new Among("aran", 16, 2),
    new Among("ieran", 16, 2),
    new Among("\u00EDan", 16, 2),
    new Among("ar\u00EDan", 20, 2),
    new Among("er\u00EDan", 20, 2),
    new Among("ir\u00EDan", 20, 2),
    new Among("en", -1, 1),
    new Among("asen", 24, 2),
    new Among("iesen", 24, 2),
    new Among("aron", -1, 2),
    new Among("ieron", -1, 2),
    new Among("ar\u00E1n", -1, 2),
    new Among("er\u00E1n", -1, 2),
    new Among("ir\u00E1n", -1, 2),
    new Among("ado", -1, 2),
    new Among("ido", -1, 2),
    new Among("ando", -1, 2),
    new Among("iendo", -1, 2),
    new Among("ar", -1, 2),
    new Among("er", -1, 2),
    new Among("ir", -1, 2),
    new Among("as", -1, 2),
    new Among("abas", 39, 2),
    new Among("adas", 39, 2),
    new Among("idas", 39, 2),
    new Among("aras", 39, 2),
    new Among("ieras", 39, 2),
    new Among("\u00EDas", 39, 2),
    new Among("ar\u00EDas", 45, 2),
    new Among("er\u00EDas", 45, 2),
    new Among("ir\u00EDas", 45, 2),
    new Among("es", -1, 1),
    new Among("ases", 49, 2),
    new Among("ieses", 49, 2),
    new Among("abais", -1, 2),
    new Among("arais", -1, 2),
    new Among("ierais", -1, 2),
    new Among("\u00EDais", -1, 2),
    new Among("ar\u00EDais", 55, 2),
    new Among("er\u00EDais", 55, 2),
    new Among("ir\u00EDais", 55, 2),
    new Among("aseis", -1, 2),
    new Among("ieseis", -1, 2),
    new Among("asteis", -1, 2),
    new Among("isteis", -1, 2),
    new Among("\u00E1is", -1, 2),
    new Among("\u00E9is", -1, 1),
    new Among("ar\u00E9is", 64, 2),
    new Among("er\u00E9is", 64, 2),
    new Among("ir\u00E9is", 64, 2),
    new Among("ados", -1, 2),
    new Among("idos", -1, 2),
    new Among("amos", -1, 2),
    new Among("\u00E1bamos", 70, 2),
    new Among("\u00E1ramos", 70, 2),
    new Among("i\u00E9ramos", 70, 2),
    new Among("\u00EDamos", 70, 2),
    new Among("ar\u00EDamos", 74, 2),
    new Among("er\u00EDamos", 74, 2),
    new Among("ir\u00EDamos", 74, 2),
    new Among("emos", -1, 1),
    new Among("aremos", 78, 2),
    new Among("eremos", 78, 2),
    new Among("iremos", 78, 2),
    new Among("\u00E1semos", 78, 2),
    new Among("i\u00E9semos", 78, 2),
    new Among("imos", -1, 2),
    new Among("ar\u00E1s", -1, 2),
    new Among("er\u00E1s", -1, 2),
    new Among("ir\u00E1s", -1, 2),
    new Among("\u00EDs", -1, 2),
    new Among("ar\u00E1", -1, 2),
    new Among("er\u00E1", -1, 2),
    new Among("ir\u00E1", -1, 2),
    new Among("ar\u00E9", -1, 2),
    new Among("er\u00E9", -1, 2),
    new Among("ir\u00E9", -1, 2),
    new Among("i\u00F3", -1, 2)
};

private final static Among[] a_9 = {
    new Among("a", -1, 1),
    new Among("e", -1, 2),
    new Among("o", -1, 1),
    new Among("os", -1, 1),
    new Among("\u00E1", -1, 1),
    new Among("\u00E9", -1, 2),
    new Among("\u00ED", -1, 1),
    new Among("\u00F3", -1, 1)
};

private static final char[] g_v = {17, 65, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 17, 4, 10 };

private int I_p2;
private int I_p1;
private int I_pV;


private void r_mark_regions() {
    I_pV = limit;
    I_p1 = limit;
    I_p2 = limit;
    int v_1 = cursor;
    lab0: {
        lab1: {
            int v_2 = cursor;
            lab2: {
                if (!(in_grouping(g_v, 252)))
                {
                    break lab2;
                }
                lab3: {
                    int v_3 = cursor;
                    lab4: {
                        if (!(out_grouping(g_v, 252)))
                        {
                            break lab4;
                        }
                        while (true) {
                            lab6:
                            {
                                if (!(in_grouping(g_v, 252))) {
                                    break lab6;
                                }
                                break;
                            }
                            if (cursor >= limit) {
                                break lab4;
                            }
                            cursor++;
                        }
                        break lab3;
                    }
                    cursor = v_3;
                    if (!(in_grouping(g_v, 252)))
                    {
                        break lab2;
                    }
                    while (true) {
                        lab8:
                        {
                            if (!(out_grouping(g_v, 252))) {
                                break lab8;
                            }
                            break;
                        }
                        if (cursor >= limit) {
                            break lab2;
                        }
                        cursor++;
                    }
                }
                break lab1;
            }
            cursor = v_2;
            if (!(out_grouping(g_v, 252)))
            {
                break lab0;
            }
            lab9: {
                int v_6 = cursor;
                lab10: {
                    if (!(out_grouping(g_v, 252)))
                    {
                        break lab10;
                    }
                    while (true) {
                        lab12:
                        {
                            if (!(in_grouping(g_v, 252))) {
                                break lab12;
                            }
                            break;
                        }
                        if (cursor >= limit) {
                            break lab10;
                        }
                        cursor++;
                    }
                    break lab9;
                }
                cursor = v_6;
                if (!(in_grouping(g_v, 252)))
                {
                    break lab0;
                }
                if (cursor >= limit)
                {
                    break lab0;
                }
                cursor++;
            }
        }
        I_pV = cursor;
    }
    cursor = v_1;
    int v_8 = cursor;
    lab13: {
        while (true) {
            lab15:
            {
                if (!(in_grouping(g_v, 252))) {
                    break lab15;
                }
                break;
            }
            if (cursor >= limit) {
                break lab13;
            }
            cursor++;
        }
        while (true) {
            lab17:
            {
                if (!(out_grouping(g_v, 252))) {
                    break lab17;
                }
                break;
            }
            if (cursor >= limit) {
                break lab13;
            }
            cursor++;
        }
        I_p1 = cursor;
        while (true) {
            lab19:
            {
                if (!(in_grouping(g_v, 252))) {
                    break lab19;
                }
                break;
            }
            if (cursor >= limit) {
                break lab13;
            }
            cursor++;
        }
        while (true) {
            lab21:
            {
                if (!(out_grouping(g_v, 252))) {
                    break lab21;
                }
                break;
            }
            if (cursor >= limit) {
                break lab13;
            }
            cursor++;
        }
        I_p2 = cursor;
    }
    cursor = v_8;
}

private void r_postlude() {
    int among_var;
    while(true)
    {
        int v_1 = cursor;
        lab0: {
            bra = cursor;
            among_var = find_among(a_0);
            if (among_var == 0)
            {
                break lab0;
            }
            ket = cursor;
            switch (among_var) {
                case 1:
                    slice_from("a");
                    break;
                case 2:
                    slice_from("e");
                    break;
                case 3:
                    slice_from("i");
                    break;
                case 4:
                    slice_from("o");
                    break;
                case 5:
                    slice_from("u");
                    break;
                case 6:
                    if (cursor >= limit)
                    {
                        break lab0;
                    }
                    cursor++;
                    break;
            }
            continue;
        }
        cursor = v_1;
        break;
    }
}

private boolean r_RV() {
    return !(I_pV <= cursor);
}

private boolean r_R1() {
    return I_p1 <= cursor;
}

private boolean r_R2() {
    return !(I_p2 <= cursor);
}

private void r_attached_pronoun() {
    int among_var;
    ket = cursor;
    if (find_among_b(a_1) == 0)
    {
        return;
    }
    bra = cursor;
    among_var = find_among_b(a_2);
    if (among_var == 0)
    {
        return;
    }
    if (r_RV())
    {
        return;
    }
    switch (among_var) {
        case 1:
            bra = cursor;
            slice_from("iendo");
            break;
        case 2:
            bra = cursor;
            slice_from("ando");
            break;
        case 3:
            bra = cursor;
            slice_from("ar");
            break;
        case 4:
            bra = cursor;
            slice_from("er");
            break;
        case 5:
            bra = cursor;
            slice_from("ir");
            break;
        case 6:
            slice_del();
            break;
        case 7:
            if (!(eq_s_b("u")))
            {
                return;
            }
            slice_del();
            break;
    }
}

private boolean r_standard_suffix() {
    int among_var;
    ket = cursor;
    among_var = find_among_b(a_6);
    if (among_var == 0)
    {
        return false;
    }
    bra = cursor;
    switch (among_var) {
        case 1:
            if (r_R2())
            {
                return false;
            }
            slice_del();
            break;
        case 2:
            if (r_R2())
            {
                return false;
            }
            slice_del();
            int v_1 = limit - cursor;
            lab0: {
                ket = cursor;
                if (!(eq_s_b("ic")))
                {
                    cursor = limit - v_1;
                    break lab0;
                }
                bra = cursor;
                if (r_R2())
                {
                    cursor = limit - v_1;
                    break lab0;
                }
                slice_del();
            }
            break;
        case 3:
            if (r_R2())
            {
                return false;
            }
            slice_from("log");
            break;
        case 4:
            if (r_R2())
            {
                return false;
            }
            slice_from("u");
            break;
        case 5:
            if (r_R2())
            {
                return false;
            }
            slice_from("ente");
            break;
        case 6:
            if (!r_R1())
            {
                return false;
            }
            slice_del();
            int v_2 = limit - cursor;
            lab1: {
                ket = cursor;
                among_var = find_among_b(a_3);
                if (among_var == 0)
                {
                    cursor = limit - v_2;
                    break lab1;
                }
                bra = cursor;
                if (r_R2())
                {
                    cursor = limit - v_2;
                    break lab1;
                }
                slice_del();
                if (among_var == 1) {
                    ket = cursor;
                    if (!(eq_s_b("at"))) {
                        cursor = limit - v_2;
                        break lab1;
                    }
                    bra = cursor;
                    if (r_R2()) {
                        cursor = limit - v_2;
                        break lab1;
                    }
                    slice_del();
                }
            }
            break;
        case 7:
            if (r_R2())
            {
                return false;
            }
            slice_del();
            int v_3 = limit - cursor;
            lab2: {
                ket = cursor;
                if (find_among_b(a_4) == 0)
                {
                    cursor = limit - v_3;
                    break lab2;
                }
                bra = cursor;
                if (r_R2())
                {
                    cursor = limit - v_3;
                    break lab2;
                }
                slice_del();
            }
            break;
        case 8:
            if (r_R2())
            {
                return false;
            }
            slice_del();
            int v_4 = limit - cursor;
            lab3: {
                ket = cursor;
                if (find_among_b(a_5) == 0)
                {
                    cursor = limit - v_4;
                    break lab3;
                }
                bra = cursor;
                if (r_R2())
                {
                    cursor = limit - v_4;
                    break lab3;
                }
                slice_del();
            }
            break;
        case 9:
            if (r_R2())
            {
                return false;
            }
            slice_del();
            int v_5 = limit - cursor;
            lab4: {
                ket = cursor;
                if (!(eq_s_b("at")))
                {
                    cursor = limit - v_5;
                    break lab4;
                }
                bra = cursor;
                if (r_R2())
                {
                    cursor = limit - v_5;
                    break lab4;
                }
                slice_del();
            }
            break;
    }
    return true;
}

private boolean r_y_verb_suffix() {
    if (cursor < I_pV)
    {
        return false;
    }
    int v_2 = limit_backward;
    limit_backward = I_pV;
    ket = cursor;
    if (find_among_b(a_7) == 0)
    {
        limit_backward = v_2;
        return false;
    }
    bra = cursor;
    limit_backward = v_2;
    if (!(eq_s_b("u")))
    {
        return false;
    }
    slice_del();
    return true;
}

private void r_verb_suffix() {
    int among_var;
    if (cursor < I_pV)
    {
        return;
    }
    int v_2 = limit_backward;
    limit_backward = I_pV;
    ket = cursor;
    among_var = find_among_b(a_8);
    if (among_var == 0)
    {
        limit_backward = v_2;
        return;
    }
    bra = cursor;
    limit_backward = v_2;
    switch (among_var) {
        case 1:
            int v_3 = limit - cursor;
            lab0: {
                if (!(eq_s_b("u")))
                {
                    cursor = limit - v_3;
                    break lab0;
                }
                int v_4 = limit - cursor;
                if (!(eq_s_b("g")))
                {
                    cursor = limit - v_3;
                    break lab0;
                }
                cursor = limit - v_4;
            }
            bra = cursor;
            slice_del();
            break;
        case 2:
            slice_del();
            break;
    }
}

private void r_residual_suffix() {
    int among_var;
    ket = cursor;
    among_var = find_among_b(a_9);
    if (among_var == 0)
    {
        return;
    }
    bra = cursor;
    switch (among_var) {
        case 1:
            if (r_RV())
            {
                return;
            }
            slice_del();
            break;
        case 2:
            if (r_RV())
            {
                return;
            }
            slice_del();
            int v_1 = limit - cursor;
            lab0: {
                ket = cursor;
                if (!(eq_s_b("u")))
                {
                    cursor = limit - v_1;
                    break lab0;
                }
                bra = cursor;
                int v_2 = limit - cursor;
                if (!(eq_s_b("g")))
                {
                    cursor = limit - v_1;
                    break lab0;
                }
                cursor = limit - v_2;
                if (r_RV())
                {
                    cursor = limit - v_1;
                    break lab0;
                }
                slice_del();
            }
            break;
    }
}

public void stem() {
    r_mark_regions();
    limit_backward = cursor;
    cursor = limit;
    int v_2 = 0;
    r_attached_pronoun();
    cursor = limit - v_2;
    int v_3 = 0;
    {
        lab1:
        {
            int v_4 = 0;
            lab2:
            {
                if (!r_standard_suffix()) {
                    break lab2;
                }
                break lab1;
            }
            cursor = limit - v_4;
            lab3:
            {
                if (!r_y_verb_suffix()) {
                    break lab3;
                }
                break lab1;
            }
            cursor = limit - v_4;
            r_verb_suffix();
        }
    }
    cursor = limit - v_3;
    r_residual_suffix();
    cursor = limit_backward;
    int v_6 = cursor;
    r_postlude();
    cursor = v_6;
}

@Override
public boolean equals( Object o ) {
    return o instanceof spanishStemmer;
}

@Override
public int hashCode() {
    return spanishStemmer.class.getName().hashCode();
}



}

