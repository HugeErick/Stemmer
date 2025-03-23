package snowball;

import java.io.Serial;

public abstract class SnowballStemmer extends SnowballProgram {
    public abstract void stem();

    @Serial
    private static final long serialVersionUID = 2016072500L;
}
