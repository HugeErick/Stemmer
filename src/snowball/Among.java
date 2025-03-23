package snowball;

import java.lang.reflect.Method;

public class Among {
    public Among (String s, int substring_i, int result) {
        this.s = s.toCharArray();
        this.substring_i = substring_i;
	this.result = result;
	this.method = null;
    }

    public final char[] s; /* search string */
    public final int substring_i; /* index to the longest matching substring */
    public final int result; /* result of the lookup */
    public final Method method; /* method to use if substring matches */
}
